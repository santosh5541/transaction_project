package com.example.transaction.repository.bankAccount;

import com.example.transaction.model.bank.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {
}
