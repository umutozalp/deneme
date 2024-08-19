package com.realestate.demo.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Titledeed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "ownername", nullable = false, length = 30)
    public String ownername;

    @Column(name = "city", nullable = false, length = 20)
    public String city;

    @Column(name="county", nullable = false, length = 20)
    public String county;

    @Column(name="district", nullable = false, length = 20)
    public String district;

    @Column(name="adress", nullable = false, length = 100)
    public String adress;

    @Column(name="otherPartners",nullable = false)
    public String otherpartners;

    @OneToMany(mappedBy ="titledeed", cascade = CascadeType.ALL)
    private List<PropertyOwners> propertyOwners;

    @OneToOne(mappedBy = "titledeed",cascade = CascadeType.ALL)
    private Property property;

}
