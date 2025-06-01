package com.example.controller;


import com.example.entity.BankCard;
import com.example.service.CardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardServiceImpl cardService;

    @GetMapping
    public List<BankCard> getAllCards() {
        return cardService.getAll();
    }

    @GetMapping("/balance")
    public ResponseEntity<Double> getBalance(Long cardId) {
        return ResponseEntity.ok(cardService.getBalance(cardId));
    }

    @PostMapping("/new")
    public void addCard(@RequestParam String cardNumber,
                        @RequestParam String cardHolderName,
                        @RequestParam String expiryDate,
                        @RequestParam String cardStatus,
                        @RequestParam Double balance
            ) {
        cardService.createCard(cardNumber, cardHolderName, expiryDate, cardStatus, balance);
    }

    @PutMapping("/balance")
    public void setBalance(Long cardId, Double balance) {
        cardService.setBalance(cardId, balance);
    }
}
