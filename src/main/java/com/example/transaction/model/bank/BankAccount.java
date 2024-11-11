package com.example.transaction.model.bank;

import com.example.transaction.model.customer.Customer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "bank_details")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNumber;
    private BigDecimal balance;
    @OneToOne(mappedBy = "bankAccount", cascade = CascadeType.ALL)
    private Customer customer;
}

