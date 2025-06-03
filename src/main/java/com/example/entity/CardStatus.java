package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CardStatus {

    ACTIVE("Активна"),
    BLOCKED("Заблокирована"),
    EXPIRED("Истёк срок");

    private final String value;

}