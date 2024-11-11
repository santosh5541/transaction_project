package com.example.transaction.service.impl.bankingImpl;

import com.example.transaction.model.customer.Customer;
import com.example.transaction.model.customer.CustomerTransactionCount;
import com.example.transaction.model.merchant.Merchant;
import com.example.transaction.model.merchant.MerchantTransactionLimit;
import com.example.transaction.repository.customer.CustomerRepository;
import com.example.transaction.repository.customer.CustomerTransactionCountRepository;
import com.example.transaction.repository.merchant.MerchantRepository;
import com.example.transaction.repository.merchant.MerchantTransactionLimitRepository;
import com.example.transaction.service.bankingService.BankingService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankingServiceImpl implements BankingService {
    private final CustomerRepository customerRepository;
    private final CustomerTransactionCountRepository customerTransactionCountRepository;
    private final MerchantRepository merchantRepository;
    private final MerchantTransactionLimitRepository merchantTransactionLimitRepository;

    @Override
    @Transactional
    public void processTransaction(int customerId, int merchantId, BigDecimal transactionAmount) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
        Merchant merchant = merchantRepository.findById(merchantId).orElseThrow(() -> new RuntimeException("Merchant not found"));
        MerchantTransactionLimit merchantTransactionLimit = merchantTransactionLimitRepository
                .findByMerchantId(merchantId).orElseThrow(() -> new RuntimeException("Merchant transaction limit not found"));

        BigDecimal dailyLimit = merchantTransactionLimit.getDailyLimit();

        List<CustomerTransactionCount> todayTransactions = customerTransactionCountRepository
                .findByCustomerIdAndTransactionDate(customerId, LocalDate.now());

        BigDecimal totalTodayTransactions = todayTransactions.stream()
                .map(CustomerTransactionCount::getTotalTransactionAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (totalTodayTransactions.add(transactionAmount).compareTo(dailyLimit) > 0) {
            throw new RuntimeException("Daily transaction limit exceeded");
        }
        if (customer.getBalance().compareTo(transactionAmount) >= 0) {
            customer.setBalance(customer.getBalance().subtract(transactionAmount));
            customerRepository.save(customer);
        } else {
            throw new RuntimeException("Insufficient balance");
        }
        CustomerTransactionCount transactionCount = new CustomerTransactionCount();
        transactionCount.setCustomer(customer);
        transactionCount.setMerchant(merchant);
        transactionCount.setTotalTransactionAmount(transactionAmount);
        transactionCount.setTransactionDate(LocalDate.now());
        customerTransactionCountRepository.save(transactionCount);
    }
}
