package com.example.transaction.exception;

public class ResponseException extends BankingException {
    public ResponseException(BankingExceptionType bankingExceptionType) {
        super(bankingExceptionType); // Now works because of the updated constructor in BankingException
    }

    public ResponseException(String message) {
        super(message);
    }

    public ResponseException() {
        super("An error occurred while processing the transaction");
    }

    public enum BankingError implements BankingExceptionType {
        INSUFFICIENT_FUNDS("INSUFFICIENT_FUNDS", "Insufficient funds in the account"),
        ACCOUNT_LOCKED("ACCOUNT_LOCKED", "The account is locked"),
        TRANSACTION_LIMIT_EXCEEDED("TRANSACTION_LIMIT_EXCEEDED", "Transaction limit exceeded"),
        CUSTOMER_NOT_FOUND("CUSTOMER_NOT_FOUND", "customer not found");
        private final String type;
        private final String message;

        BankingError(String type, String message) {
            this.type = type;
            this.message = message;
        }

        @Override
        public String getType() {
            return type;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }
}
