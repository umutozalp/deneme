package com.realestate.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="incomeType",length=40,nullable=false)
    private String incometype;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="invoiceId")
    private Invoice invoice;

    @Column(name="amount",nullable=false)
    private Double amount;

    @Column(name="description",length=100)
    private String description;

    @Column(name="paymentDate",nullable=false)
    private LocalDate paymentdate;
}
