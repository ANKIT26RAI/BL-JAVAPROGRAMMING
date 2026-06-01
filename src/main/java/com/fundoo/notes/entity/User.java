package com.fundoo.notes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private LocalDateTime createdAt;
    private boolean premium = false;

    private String subscriptionPlan = "FREE";

    private LocalDateTime subscriptionStartDate;

    private LocalDateTime subscriptionEndDate;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Note> notes;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.subscriptionPlan == null) {
            this.subscriptionPlan = "FREE";
        }
    }
}