package com.example.transaction.repository.merchant;

import com.example.transaction.model.merchant.MerchantTransactionLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MerchantTransactionLimitRepository extends JpaRepository<MerchantTransactionLimit, Integer> {
    Optional<MerchantTransactionLimit> findByMerchantId(int merchantId);
}
