package com.blockchain.kyc.api;

import com.blockchain.kyc.model.Customer;
import com.blockchain.kyc.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@Controller
@AllArgsConstructor
@RequestMapping("customer")
public class CustomerController {

    private CustomerService customerService;

    @PostMapping("/register")
    public String register(@ModelAttribute("customer") Customer customer){
        if(customerService.isCustomerAlreadyRegistered(customer)){
            return "Already Registered";
        }
        customerService.registerNewCustomer(customer);
        return "redirect:/customer/login";
    }

    @PostMapping("/update/{id}")
    public String updateCustomer(@ModelAttribute("customer") Customer customer,@PathVariable("id") long id){
        return customerService.updateCustomerDetails(customer,id);
    }

    @GetMapping("/profile/{id}")
    public String getCustomerProfile(Model model,@PathVariable("id") long id) {
        Customer customer = customerService.getCustomerDetailsById(id);
        model.addAttribute("customer", customer);
        return "customer_profile";
    }

    @GetMapping("/login")
    public String login(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "login";
    }

    @PostMapping("/login")
    public String loginCustomer(@ModelAttribute("customer") Customer customer) {
        Customer existingCustomer = customerService.getCustomerDetailsByEmail(customer.getEmail());
        if(null != existingCustomer ) {
            if(customer.getPassword().equals(existingCustomer.getPassword())) {
                return "redirect:/customer/profile/"+existingCustomer.getId();
            }
        }
        return "login";
    }

    @GetMapping("/register")
    public String registerNewCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "register";
    }

}
