package com.example.transaction.controller.bankAccount;

import com.example.transaction.model.bank.BankAccount;
import com.example.transaction.service.bankAccountService.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/bankAccount")
public class BankAccountController {
    private final BankAccountService bankAccountService;

    @PostMapping("/save")
    public ResponseEntity<BankAccount> saveBankAccount(@RequestBody BankAccount account) {
        BankAccount bankAccount = bankAccountService.saveBankAccount(account);
        return new ResponseEntity<>(bankAccount, HttpStatus.CREATED);
    }
}

