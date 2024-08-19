package com.realestate.demo.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
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

    @Column(name="amount",nullable=false)
    private Double amount;

    @Column(name="description",length=100)
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name="paymentDate",nullable=false,length=10)
    private LocalDate paymentdate;


    @OneToMany(mappedBy = "invoice",cascade = CascadeType.ALL)
    private List<Expense> expense;

    @OneToMany(mappedBy = "invoice",cascade = CascadeType.ALL)
    private List<Income> income;


}
