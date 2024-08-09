package com.realestate.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name ="Users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class    User {


    //@SequenceGenerator(name="seq_id",allocationSize=1)
    // @GeneratedValue(generator="seq_id",strategy=GenerationType.SEQUENCE)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;
    @Column(name = "username")
    private String Username;
    @Column(name = "password")
    private String Password;
    @Column(name = "role")
    private String Role;


}

