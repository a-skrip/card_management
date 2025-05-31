package com.example.bankcards.entity;


import com.example.bankcards.enums.CardStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "bank_cards")
public class BankCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String cardNumber; // Зашифрованное значение

    @Column(nullable = false)
    private String maskedNumber; // "**** **** **** 1234"

    @Column(nullable = false)
    private String cardHolderName;

    @Column(nullable = false)
    private String expiryDate; // MM/yy

    @Enumerated(EnumType.STRING)
    private CardStatus status = CardStatus.ACTIVE;

    @Column(nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


}

