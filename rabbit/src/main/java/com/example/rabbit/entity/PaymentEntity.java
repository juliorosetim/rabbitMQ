package com.example.rabbit.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "payment")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq")
    @SequenceGenerator(name = "payment_seq", sequenceName = "payment_seq", allocationSize = 1)
    private Long id;
    private BigDecimal value;
}
