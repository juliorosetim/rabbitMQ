package com.example.rabbit.service;

import com.example.rabbit.entity.PaymentEntity;
import com.example.rabbit.respository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository repository;

    public PaymentEntity insertPayment(PaymentEntity paymentEntity){
        return repository.save(paymentEntity);
    }
}
