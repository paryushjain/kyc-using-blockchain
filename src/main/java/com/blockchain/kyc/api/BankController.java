package com.blockchain.kyc.api;

import com.blockchain.kyc.model.Bank;
import com.blockchain.kyc.model.Customer;
import com.blockchain.kyc.service.BankService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("bank")
public class BankController {

    BankService bankService;

    @GetMapping("/login")
    public String login(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "bank_login";
    }

    @PostMapping("/login")
    public String loginCustomer(@ModelAttribute("customer") Customer customer) {
        Bank existingBank = bankService.getCustomerDetailsByEmail(customer.getEmail());
        if(null != existingBank ) {
            if(customer.getPassword().equals(existingBank.getPassword())) {
                return "redirect:/bank/profile/"+existingBank.getId();
            }
        }
        return "bank_login";
    }

}
