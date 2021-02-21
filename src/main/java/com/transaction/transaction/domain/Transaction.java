package com.transaction.transaction.domain;

import java.time.LocalDateTime;

public class Transaction {

    private Integer transactonNumber;
    private String accountNumber;
    private LocalDateTime transactionTs;
    private Double amount;
    private String transactionType;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getTransactonNumber() {
        return transactonNumber;
    }

    public void setTransactonNumber(Integer transactonNumber) {
        this.transactonNumber = transactonNumber;
    }

    public Transaction(Integer transactonNumber, String accountNumber, LocalDateTime transactionTs, Double amount,
                       String transactionType) {
        this.transactonNumber = transactonNumber;
        this.accountNumber = accountNumber;
        this.transactionTs = transactionTs;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDateTime getTransactionTs() {
        return transactionTs;
    }

    public void setTransactionTs(LocalDateTime transactionTs) {
        this.transactionTs = transactionTs;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }



    @Override
    public String toString() {
        return "Transaction{" +
                "accountNumber='" + accountNumber + '\'' +
                ", transactionTs=" + transactionTs +
                ", amount=" + amount +
                ", transactionType='" + transactionType + '\'' +
                '}';
    }

}
