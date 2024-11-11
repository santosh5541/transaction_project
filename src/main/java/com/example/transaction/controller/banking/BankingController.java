package com.example.transaction.controller.banking;

import com.example.transaction.service.bankingService.BankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/banking")
public class BankingController {
    private final BankingService bankingService;

    @PostMapping("/save")
    public ResponseEntity<String> processTransaction(@RequestParam int customerId,
                                                     @RequestParam int merchantId,
                                                     @RequestParam BigDecimal transactionAmount) {
        try {
            bankingService.processTransaction(customerId, merchantId, transactionAmount);
            return ResponseEntity.ok("Transaction successful");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/reverse")
    public ResponseEntity<String> reverseTransaction(@RequestParam int customerId,
                                                     @RequestParam BigDecimal transactionAmount) {
        try {
            bankingService.rollbackTransaction(customerId, transactionAmount);
            return ResponseEntity.ok("Transaction rolled back successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
