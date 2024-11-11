package com.example.transaction.service.impl.bankAccountServiceImpl;

import com.example.transaction.model.bank.BankAccount;
import com.example.transaction.repository.bankAccount.BankAccountRepository;
import com.example.transaction.service.bankAccountService.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {
    private final BankAccountRepository bankAccountRepository;

    @Override
    public BankAccount saveBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }
}
