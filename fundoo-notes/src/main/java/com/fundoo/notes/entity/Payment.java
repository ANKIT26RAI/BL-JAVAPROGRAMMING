package com.fundoo.notes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String razorpayOrderId;

    private String razorpayPaymentId;

    private String razorpaySignature;

    private Integer amount;

    private String currency;

    private String status;

    private String planName;

    private LocalDateTime createdAt;

    private LocalDateTime paidAt;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();

        if (this.currency == null) {
            this.currency = "INR";
        }

        if (this.status == null) {
            this.status = "CREATED";
        }
    }
}