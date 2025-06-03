package com.example.repository;

import com.example.entity.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<BankCard, Long> {

    List<BankCard> findAll();

    List<BankCard> findAllByUserId(Long userId);

    BankCard findBankCardById(Long cardId);

    //TODO Переделать на Entity
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO bank_cards (card_number, card_holder_name, expiry_date, status, balance)" +
            " VALUES (:cardNumber, :cardHolderName, :expiryDate, :cardStatus, :balance)", nativeQuery = true)
    void createCard(@Param("cardNumber") String cardNumber,
                    @Param("cardHolderName") String cardHolderName,
                    @Param("expiryDate") String expiryDate,
                    @Param("cardStatus") String cardStatus,
                    @Param("balance") Double balance) ;


    void deleteBankCardById(Long cardId);


}
