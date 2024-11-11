package com.example.transaction.model.customer;

import com.example.transaction.model.bank.BankAccount;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private BigDecimal balance;
    @OneToOne
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankAccount;
}

