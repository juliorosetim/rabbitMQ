package com.example.rabbit.controller;

import com.example.rabbit.entity.PaymentEntity;
import com.example.rabbit.service.PaymentService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostMapping
    public void insertPayment(@RequestBody PaymentEntity paymentEntity) {
        PaymentEntity paymentSave = paymentService.insertPayment(paymentEntity);


        rabbitTemplate.convertAndSend("payment.v1.exchange", "", paymentSave);

    }
}
