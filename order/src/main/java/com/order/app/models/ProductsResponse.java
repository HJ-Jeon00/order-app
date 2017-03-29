package com.order.app.models;

import java.util.List;

/**
 * Created by Joel.Gonzales on 3/29/2017.
 */
public class ProductsResponse {

  private List<Product> products;

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }
}
