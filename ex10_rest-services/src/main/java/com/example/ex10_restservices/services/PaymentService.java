package com.example.ex10_restservices.services;

import com.example.ex10_restservices.exception.NotEnoughMoneyException;
import com.example.ex10_restservices.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
