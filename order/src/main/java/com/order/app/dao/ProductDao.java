package com.order.app.dao;

import com.order.app.models.Product;
import com.order.app.models.ProductsResponse;

/**
 * Created by Joel.Gonzales on 3/29/2017.
 */
public interface ProductDao {
  ProductsResponse browse(String type);
  void add(Product product);
  void update(Product product);
  void delete(Integer product_id);
}
