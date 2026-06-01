package com.fundoo.notes.controller;

import com.fundoo.notes.dto.CreateOrderRequest;
import com.fundoo.notes.dto.VerifyPaymentRequest;
import com.fundoo.notes.entity.User;
import com.fundoo.notes.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create-order")
    public ResponseEntity<Map<String, Object>> createOrder(
            @Valid @RequestBody CreateOrderRequest request,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(paymentService.createOrder(request, user));
    }

    @PostMapping("/verify")
    public ResponseEntity<String> verifyPayment(
            @Valid @RequestBody VerifyPaymentRequest request,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(paymentService.verifyPayment(request, user));
    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, Object>> getPaymentStatus(
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(paymentService.getPaymentStatus(user));
    }
}