package com.order.app.services.types;

import com.order.app.dao.ProductDao;
import com.order.app.models.Product;
import com.order.app.models.ProductsResponse;
import com.order.app.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Joel.Gonzales on 3/29/2017.
 */
@Component
public class ProductServiceImpl implements ProductService{

  private ProductDao productDao;

  @Autowired
  public ProductServiceImpl(ProductDao productDao) {
    this.productDao = productDao;
  }

  @Override
  public ProductsResponse browse(String type) {
    return productDao.browse(type);
  }

  @Override
  public void add(Product product) {
    productDao.add(product);
  }

  @Override
  public void update(Product product) {
    productDao.update(product);
  }

  @Override
  public void delete(Integer product_id) {
    productDao.delete(product_id);
  }
}
