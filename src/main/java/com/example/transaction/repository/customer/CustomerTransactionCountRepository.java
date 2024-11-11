package com.example.transaction.repository.customer;

import com.example.transaction.model.customer.CustomerTransactionCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerTransactionCountRepository extends JpaRepository<CustomerTransactionCount, Integer> {
    List<CustomerTransactionCount> findByCustomerIdAndTransactionDate(int customerId, LocalDate date);

    @Query("SELECT c FROM CustomerTransactionCount c WHERE c.customer.id = :customerId AND c.totalTransactionAmount = :transactionAmount AND c.transactionDate = :transactionDate")
    Optional<CustomerTransactionCount> findByCustomerIdAndTransactionAmountAndTransactionDate(
            @Param("customerId") int customerId,
            @Param("transactionAmount") BigDecimal transactionAmount,
            @Param("transactionDate") LocalDate transactionDate
    );
}
