package com.example.demo.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BankController {

    @Autowired
    private BankService bankService;  // Inject the BankService

    @GetMapping("/bank")
    public String displayBankSystem(Model model) {
        model.addAttribute("message", "Welcome to the Bank System");
        return "bank"; // This should match the name of the view template (e.g., bank.html)
    }

    @PostMapping("/deposit")
    public String depositMoney(@RequestParam("accountNo") String accountNo,
                               @RequestParam("amount") double amount, Model model) {
        boolean success = bankService.depositMoney(accountNo, amount);
        if (success) {
            model.addAttribute("message", "Deposit Successful.");
        } else {
            model.addAttribute("message", "Account not found.");
        }
        return "bank";  // Return to the bank view
    }

    @PostMapping("/withdraw")
    public String withdrawMoney(@RequestParam("accountNo") String accountNo,
                                @RequestParam("amount") double amount, Model model) {
        boolean success = bankService.withdrawMoney(accountNo, amount);
        if (success) {
            model.addAttribute("message", "Withdrawal Successful.");
        } else {
            model.addAttribute("message", "Account not found or insufficient funds.");
        }
        return "bank";  // Return to the bank view
    }
}
