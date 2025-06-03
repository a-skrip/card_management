package com.example.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bank_cards")
public class BankCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String cardNumber; // Зашифрованное значение

    @Column(nullable = false)
    private String cardHolderName;

    @Column(nullable = false)
    private String expiryDate; // MM/yy

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Double balance;


//    @Column(nullable = false)
//    private String maskedNumber; // "**** **** **** 1234"


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


}

