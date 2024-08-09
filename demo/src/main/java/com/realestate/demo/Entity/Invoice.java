package com.realestate.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="contractId")
    private Contract contract;

    @Column(name="amount")
    private double amount;
    @Column(name="description")
    private String description;
    @Column(name="paymentDate")
    private Date paymentdate;


    @OneToMany(mappedBy = "invoice",cascade = CascadeType.ALL)
    private List<Expense> expense;
    @OneToMany(mappedBy = "invoice",cascade = CascadeType.ALL)
    private List<Income> income;


}
