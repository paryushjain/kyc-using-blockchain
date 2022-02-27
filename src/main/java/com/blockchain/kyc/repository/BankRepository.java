package com.blockchain.kyc.repository;

import com.blockchain.kyc.model.Bank;
import com.blockchain.kyc.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface BankRepository extends JpaRepository<Bank, Long> {
    Bank findByEmail(String email);
}
