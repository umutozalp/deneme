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
public class  SystemUsers {


    //@SequenceGenerator(name="seq_id",allocationSize=1)
    // @GeneratedValue(generator="seq_id",strategy=GenerationType.SEQUENCE)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username",nullable = false,length = 50)
    private String username;

    @Column(name="password",nullable = false,length = 100)
    private String password;

    @Column(name="role",nullable = false,length = 15)
    private String role;
}