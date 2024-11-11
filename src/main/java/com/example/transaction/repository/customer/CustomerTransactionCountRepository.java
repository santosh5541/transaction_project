package com.example.transaction.repository.customer;

import com.example.transaction.model.customer.CustomerTransactionCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerTransactionCountRepository extends JpaRepository<CustomerTransactionCount, Integer> {
    List<CustomerTransactionCount> findByCustomerIdAndTransactionDate(int customerId, LocalDate date);
}
