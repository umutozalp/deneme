package com.realestate.demo.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ExpenseType",length =100,nullable = false)
    private String expensetype;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoiceId")
    private Invoice invoice;

    @Column(name = "amount",nullable = false)
    private Double amount;

    @Column(name = "Description",length =100)
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "paymentDate",length = 10,nullable = false)
    private LocalDate paymentdate;
}
