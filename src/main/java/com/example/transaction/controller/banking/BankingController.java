package com.example.transaction.controller.banking;

import com.example.transaction.service.bankingService.BankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("Controller is working!");
    }
}
