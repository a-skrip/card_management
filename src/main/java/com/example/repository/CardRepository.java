package com.example.repository;

import com.example.entity.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CardRepository extends JpaRepository <BankCard, Long> {

    List<BankCard> findAll ();

}
