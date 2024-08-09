package com.realestate.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int id;

    @Column(name="ExpenseType")
    public String expensetype;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="invoiceId")
    public Invoice invoice;

    @Column(name="amount")
    public double amount;
    @Column(name="Description")
    public String description;
    @Column(name="paymentDate")
    public Date paymentdate;
}
