package com.example.controller;

import com.example.model.Account;
import com.example.model.TransferRequest;
import com.example.service.TransferService;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Target;
import java.util.List;

@RestController
public class AccountController {
    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest request) {
        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount());
    }

    @GetMapping("/accounts/all")
    public Iterable<Account> getAllAccounts() {
        return transferService.getAllAccounts();
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAccountByName(@RequestParam String name) {
        return transferService.findAccountsByName(name);
    }
}
