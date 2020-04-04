package com.miempresa.api.rest.models.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="product")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  //@Column(name="id")
  private Long id;

  private String name;
  private String description;

  //@Column(name="create_at")
  @Temporal(TemporalType.DATE)
  private Date createAt;

  public Product(){}

  public Product(String name, String description, Date createAt){
    this.name = name;
    this.description = description;
    this.createAt = createAt;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getCreateAt() {
    return createAt;
  }

  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }


}
