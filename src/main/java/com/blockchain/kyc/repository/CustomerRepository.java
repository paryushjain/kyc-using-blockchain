package com.blockchain.kyc.repository;

import com.blockchain.kyc.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
    Customer findByAadharNo(String pan);
    Customer findByPanNo(String pan);
}
