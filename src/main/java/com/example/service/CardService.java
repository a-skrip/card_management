package com.example.service;

import com.example.entity.BankCard;

import java.util.List;

public interface CardService {

    List<BankCard> getAll();

    Double getBalance(Long cardId);

    void createCard(String cardNumber, String cardHolderName, String expiryDate, String cardStatus, Double balance);

    void setBalance(Long cardId, Double balance);

    void transferCardToCard(Long fromCardId, Long toCardId, Double amount);

    BankCard setStatusCard(Long cardId, String statusCard);

    void deleteCard(Long cardId);

}
