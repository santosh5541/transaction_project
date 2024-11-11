package com.example.transaction.exception;

import lombok.Getter;

@Getter
public class BankingException extends Exception {
    private final String type;
    private final String message;

    public BankingException(BankingExceptionType bankingExceptionType) {
        super(bankingExceptionType.getMessage());
        this.type = bankingExceptionType.getType();
        this.message = bankingExceptionType.getMessage();
    }

    public BankingException(String message) {
        super(message);
        this.type = null;
        this.message = message;
    }
}
