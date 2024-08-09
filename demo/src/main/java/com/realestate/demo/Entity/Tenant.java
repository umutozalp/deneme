package com.realestate.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="tenantName")
    private String tenantname;
    @Column(name="phone")
    private String phone;
    @Column(name="email")
    private String email;

    @OneToMany(mappedBy = "tenant",cascade = CascadeType.ALL)
    private List<Contract> contract;


}
