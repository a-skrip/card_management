//package com.example.util;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EncryptionService {
//
//    @Value("${encryption.key}")
//    private String encryptionKey;
//
//    public String encrypt(String data) {
//        // Реализация шифрования (AES)
//        return null;
//    }
//
//    public String decrypt(String encryptedData) {
//        // Реализация дешифрования
//        return null;
//    }
//
//    public String maskCardNumber(String cardNumber) {
//        return "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
//    }
//}