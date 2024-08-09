package com.realestate.demo.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "titledeedId")
    private Titledeed titledeed;
    @Column(name = "propertyType")
    private String propertytype;
    @Column(name = "adress")
    private String adress;
    @Column(name = "district")
    private String district;
    @Column(name = "county")
    private String county;
    @Column(name = "city")
    private String city;
    @Column(name = "OwnerName")
    private String ownername;
    @Column(name = "ownerCount")
    private int ownercount;


    @OneToMany(mappedBy = "property",cascade = CascadeType.ALL)
    private List<Contract> contract;

    @OneToMany(mappedBy = "property",cascade = CascadeType.ALL)
    private List<Attachment> attachments;

    
}
