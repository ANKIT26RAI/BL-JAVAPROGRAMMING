package com.fundoo.notes.repository;

import com.fundoo.notes.entity.Payment;
import com.fundoo.notes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findByRazorpayOrderId(String razorpayOrderId);

    List<Payment> findByUser(User user);
}