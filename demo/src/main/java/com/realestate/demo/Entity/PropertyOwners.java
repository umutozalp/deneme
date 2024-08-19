package com.realestate.demo.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyOwners {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "ownerName")
    private  String ownername;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TitledeedId")
    private Titledeed titledeed;

    @Column(name = "ownerPhone",length =11,nullable = false)
    private String ownerphone;

    @Column(name = "ownerEmail",nullable = false,length =25)
    private String owneremail;
}
