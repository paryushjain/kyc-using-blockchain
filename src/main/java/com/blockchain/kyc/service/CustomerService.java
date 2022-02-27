package com.blockchain.kyc.service;

import com.blockchain.kyc.model.Customer;
import com.blockchain.kyc.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    public boolean isCustomerAlreadyRegistered(Customer customer){
        return null != customerRepository.findByEmail(customer.getEmail()) ||
                null != customerRepository.findByAadharNo(customer.getAadharNo()) ||
                null != customerRepository.findByPanNo(customer.getPanNo());
    }

    public Customer getCustomerDetailsByEmail(String email){
        return customerRepository.findByEmail(email);
    }

    public Customer getCustomerDetailsById(Long id){
        return customerRepository.getById(id);
    }

    public boolean verifyCustomerCredentials(String email, String password){
        return false;
    }

    public void registerNewCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public String updateCustomerDetails(Customer customer, long id){
        Customer existingCustomer = customerRepository.getById(id);
        existingCustomer.setSelectedBank(customer.getSelectedBank());
        existingCustomer.setPhoneNo(customer.getPhoneNo());
        customerRepository.save(existingCustomer);
        return "redirect:/customer/profile/"+existingCustomer.getId();
    }
}
