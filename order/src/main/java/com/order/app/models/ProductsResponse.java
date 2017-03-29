package com.order.app.models;

import com.order.app.models.display.ProductDisplayData;

import java.util.List;

/**
 * Created by Joel.Gonzales on 3/29/2017.
 */
public class ProductsResponse {

  private List<ProductDisplayData> products;

  public List<ProductDisplayData> getProducts() {
    return products;
  }

  public void setProducts(List<ProductDisplayData> products) {
    this.products = products;
  }
}
