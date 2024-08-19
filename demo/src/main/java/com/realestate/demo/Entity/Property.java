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

    @Column(name = "propertyType",length = 50,nullable = false)
    private String propertytype;

    @Column(name = "adress",length = 100,nullable = false)
    private String adress;

    @Column(name = "district",length=50,nullable = false)
    private String district;

    @Column(name = "county",length=50,nullable = false)
    private String county;

    @Column(name = "city",length=50,nullable = false)
    private String city;

    @Column(name = "OwnerName",length = 40,nullable = false)
    private String ownername;

    @Column(name = "ownerCount",columnDefinition = "INTEGER DEFAULT 1")
    private int ownercount;


    @OneToMany(mappedBy = "property",cascade = CascadeType.ALL)
    private List<Contract> contract;

    @OneToMany(mappedBy = "property",cascade = CascadeType.ALL)
    private List<Attachment> attachment;

    
}
