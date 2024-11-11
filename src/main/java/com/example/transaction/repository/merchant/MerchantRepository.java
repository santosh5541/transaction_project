package com.example.transaction.repository.merchant;

import com.example.transaction.model.merchant.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Integer> {
    Optional<Merchant> findById(int id);
}
