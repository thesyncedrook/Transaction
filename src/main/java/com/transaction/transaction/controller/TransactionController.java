package com.transaction.transaction.controller;

import com.transaction.transaction.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TransactionController {

    private Map<Integer, Transaction> transactionMap = new HashMap<>();
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/transaction")
    public ResponseEntity<Object> createAccount(@RequestBody Transaction transaction) throws Exception {
        transaction.setTransactionTs(LocalDateTime.now());
        Transaction put = transactionMap.put(transaction.getTransactonNumber(), transaction);
        String transactionType = transaction.getTransactionType();
        if (transactionType.equals("WITHDRAW")) {
            transaction.setType("WITHDRAW_TRANSACTION_HAPPENED");
        } else {
            transaction.setType("DEPOSIT_TRANSACTION_HAPPENED");
        }
        for (Map.Entry<Integer, Transaction> entry : transactionMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
        }
        int ptt = 0;
        try {
            ptt = put.getTransactonNumber();
        } catch (NullPointerException e) {

        }
        ;
        if (ptt == 0) {
            final String uri = "http://localhost:8085/events";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject(uri, transaction, Transaction.class);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
