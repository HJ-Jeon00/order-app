package com.order.app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by Joel.Gonzales on 3/29/2017.
 */
@Entity
@Table(name = "products")
public class Product {

  @Id
  @NotNull
  private Integer product_id;
  @NotNull
  private String name;
  @NotNull
  private String type;
  @NotNull
  private String description;

  public Integer getProduct_id() {
    return product_id;
  }

  public void setProduct_id(Integer product_id) {
    this.product_id = product_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
