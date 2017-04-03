package com.order.app.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by bryan.bernabe on 4/3/2017.
 */
@Entity
@Table(name = "orders")
public class Order {
  private Integer order_id;
  private User user;
  private List<Product> products;
  private String size;
  private String remarks;
  private String date;



  public Integer getOrder_id() {
    return order_id;
  }

  public void setOrder_id(Integer order_id) {
    this.order_id = order_id;
  }

  @OneToMany(cascade = CascadeType.ALL)
  @JoinTable(
    name = "orders",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "order_id")
  )
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @OneToMany(cascade = CascadeType.ALL)
  @JoinTable(
    name = "orders",
    joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "order_id")
  )
  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }
}
