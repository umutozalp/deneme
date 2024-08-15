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
    @Column(name = "ownername")
    public String ownername;
    @Column(name = "city")
    public String city;
    @Column(name="county")
    public String county;
    @Column(name="district")
    public String district;
    @Column(name="adress")
    public String adress;
    @Column(name="otherPartners")
    public String otherpartners;

    @OneToMany(mappedBy ="titledeed", cascade = CascadeType.ALL)
    private List<PropertyOwners> propertyOwners;

   @JsonIgnore
    @OneToOne(mappedBy = "titledeed",cascade = CascadeType.ALL)
    private Property property;

}
