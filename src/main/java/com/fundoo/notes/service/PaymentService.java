package com.fundoo.notes.service;

import com.fundoo.notes.dto.CreateOrderRequest;
import com.fundoo.notes.dto.VerifyPaymentRequest;
import com.fundoo.notes.entity.Payment;
import com.fundoo.notes.entity.User;
import com.fundoo.notes.repository.PaymentRepository;
import com.fundoo.notes.repository.UserRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.Utils;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;

    @Value("${razorpay.key.id}")
    private String razorpayKeyId;

    @Value("${razorpay.key.secret}")
    private String razorpayKeySecret;

    public Map<String, Object> createOrder(CreateOrderRequest request, User user) {
        try {
            RazorpayClient razorpayClient = new RazorpayClient(razorpayKeyId, razorpayKeySecret);

            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", request.getAmount());
            orderRequest.put("currency", "INR");
            orderRequest.put("receipt", "fundoo_receipt_" + System.currentTimeMillis());

            Order order = razorpayClient.orders.create(orderRequest);

            Payment payment = Payment.builder()
                    .razorpayOrderId(order.get("id"))
                    .amount(request.getAmount())
                    .currency("INR")
                    .status("CREATED")
                    .planName(request.getPlanName())
                    .user(user)
                    .build();

            paymentRepository.save(payment);

            Map<String, Object> response = new HashMap<>();
            response.put("orderId", order.get("id"));
            response.put("amount", request.getAmount());
            response.put("currency", "INR");
            response.put("keyId", razorpayKeyId);
            response.put("planName", request.getPlanName());
            response.put("message", "Razorpay order created successfully");

            return response;

        } catch (Exception e) {
            throw new RuntimeException("Failed to create Razorpay order: " + e.getMessage());
        }
    }

    public String verifyPayment(VerifyPaymentRequest request, User user) {
        try {
            Payment payment = paymentRepository.findByRazorpayOrderId(request.getRazorpayOrderId())
                    .orElseThrow(() -> new RuntimeException("Payment order not found"));

            if (!payment.getUser().getId().equals(user.getId())) {
                throw new RuntimeException("Payment does not belong to current user");
            }

            JSONObject options = new JSONObject();
            options.put("razorpay_order_id", request.getRazorpayOrderId());
            options.put("razorpay_payment_id", request.getRazorpayPaymentId());
            options.put("razorpay_signature", request.getRazorpaySignature());

            boolean isValidSignature = Utils.verifyPaymentSignature(options, razorpayKeySecret);

            if (!isValidSignature) {
                payment.setStatus("FAILED");
                paymentRepository.save(payment);
                throw new RuntimeException("Invalid payment signature");
            }

            payment.setRazorpayPaymentId(request.getRazorpayPaymentId());
            payment.setRazorpaySignature(request.getRazorpaySignature());
            payment.setStatus("PAID");
            payment.setPaidAt(LocalDateTime.now());
            paymentRepository.save(payment);

            user.setPremium(true);
            user.setSubscriptionPlan(payment.getPlanName());
            user.setSubscriptionStartDate(LocalDateTime.now());
            user.setSubscriptionEndDate(LocalDateTime.now().plusMonths(1));
            userRepository.save(user);

            return "Payment verified successfully. Premium subscription activated.";

        } catch (Exception e) {
            throw new RuntimeException("Payment verification failed: " + e.getMessage());
        }
    }

    public Map<String, Object> getPaymentStatus(User user) {
        Map<String, Object> response = new HashMap<>();

        response.put("premium", user.isPremium());
        response.put("subscriptionPlan", user.getSubscriptionPlan()!=null?user.getSubscriptionPlan():"FREE");
        response.put("subscriptionStartDate", user.getSubscriptionStartDate());
        response.put("subscriptionEndDate", user.getSubscriptionEndDate());

        return response;
    }
}