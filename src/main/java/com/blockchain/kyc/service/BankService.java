package com.blockchain.kyc.service;

import com.blockchain.kyc.model.Bank;
import com.blockchain.kyc.model.Customer;
import com.blockchain.kyc.repository.BankRepository;
import com.blockchain.kyc.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BankService {

    private BankRepository bankRepository;

    public Bank getCustomerDetailsByEmail(String email){
        return bankRepository.findByEmail(email);
    }

}
