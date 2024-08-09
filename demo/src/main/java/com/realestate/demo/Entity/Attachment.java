package com.realestate.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Attachment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name="propertyId")
  private Property property;

  @OneToMany(mappedBy = "attachment" ,cascade = CascadeType.ALL)
  private List<Image> image;

  @Column(name="attachmentType")
  private String attachmenttype;

  @Column(name="description")
  private String description;

  @Column(name = "fileUrl") // Yeni eklenen alan
  private String fileUrl; // Yeni eklenen alan

}
