package com.example.service;

import com.example.entity.BankCard;
import com.example.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Override
    public List<BankCard> getAll() {
        return cardRepository.findAll();
    }

    @Override
    public Double getBalance(Long cardId) {

        BankCard bankCard = cardRepository.findBankCardById(cardId);
        return bankCard.getBalance();
    }

    //TODO Переделать сигнатуру на Entity
    @Override
    public void createCard(String cardNumber,
                           String cardHolderName,
                           String expiryDate,
                           String cardStatus,
                           Double balance) {
        cardRepository.createCard(cardNumber,
                cardHolderName,
                expiryDate,
                cardStatus,
                balance);
    }

    @Transactional
    @Override
    public void setBalance(Long cardId, Double amount) {

        BankCard bankCard = cardRepository.findBankCardById(cardId);

        bankCard.setBalance(amount);

    }

    @Transactional
    @Override
    public void transferCardToCard(Long fromCardId, Long toCardId, Double amount) {

        BankCard fromBankCard = cardRepository.findBankCardById(fromCardId);
        Double balanceFrom = fromBankCard.getBalance();
        Double minus = balanceFrom - amount;
        fromBankCard.setBalance(minus);

        BankCard toBankCard = cardRepository.findBankCardById(toCardId);
        Double balanceTo = toBankCard.getBalance();
        Double plus = balanceTo + amount;
        toBankCard.setBalance(plus);

    }

    @Override
    public void setStatusCard(Long cardId, String status) {
        BankCard bankCardById = cardRepository.findBankCardById(cardId);
        bankCardById.setCardStatus(status);
    }

    @Override
    public void deleteCard(Long cardId) {
        cardRepository.deleteBankCardById(cardId);
    }
}
