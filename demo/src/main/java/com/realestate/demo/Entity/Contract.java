package com.realestate.demo.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "propertyId")
    private Property property;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tenantId")
    private Tenant tenant;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "startDate",nullable = false)
    private LocalDate startdate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "expireDate",nullable = false)
    private LocalDate expiredate;

    @Column(name = "period",nullable = false)
    private int period;

    @Column(name = "hire",nullable = false)
    private int hire;

    @Column(name = "PhoneNumber",nullable = false)
    private String phonenumber;

    @OneToMany(mappedBy = "contract",cascade = CascadeType.ALL)
    private List<Invoice> invoice;

}
