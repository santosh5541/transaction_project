package com.example.transaction.service.bankingService;

import java.math.BigDecimal;

public interface BankingService {
    public void processTransaction(int customerId, int merchantId, BigDecimal transactionAmount);

    public void rollbackTransaction(int customerId, BigDecimal transactionAmount);
}
