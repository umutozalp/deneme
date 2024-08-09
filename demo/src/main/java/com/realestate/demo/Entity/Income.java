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
@NoArgsConstructor
@AllArgsConstructor
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="incomeType")
    private String incometype;

    @Column(name="invoideId")
    private int invoiceid;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="invoiceId")
    private Invoice invoice;

    @Column(name="amount")
    private double amount;
    @Column(name="description")
    private String description;
    @Column(name="paymentDate")
    private Date paymentDate;
}
