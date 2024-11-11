package com.example.transaction.model.merchant;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class MerchantTransactionLimit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private BigDecimal dailyLimit;
    @ManyToOne
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;
}
