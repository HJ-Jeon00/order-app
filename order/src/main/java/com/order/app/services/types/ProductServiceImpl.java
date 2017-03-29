package com.order.app.services.types;

import com.order.app.dao.ProductDao;
import com.order.app.mappers.ProductDisplayDataMapper;
import com.order.app.models.Product;
import com.order.app.models.ProductsResponse;
import com.order.app.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Joel.Gonzales on 3/29/2017.
 */
@Component
public class ProductServiceImpl implements ProductService{

  private ProductDao productDao;
  private ProductDisplayDataMapper productDisplayDataMapper;

  @Autowired
  public ProductServiceImpl(ProductDao productDao, ProductDisplayDataMapper productDisplayDataMapper) {
    this.productDao = productDao;
    this.productDisplayDataMapper = productDisplayDataMapper;
  }

  @Override
  public ProductsResponse browse(String type) {
    ProductsResponse productsResponse = new ProductsResponse();
    List<Product> products = productDao.browse(type);
    if(products != null && !products.isEmpty()) {
      productsResponse.setProducts(this.productDisplayDataMapper.map(products));
    }
    return productsResponse;
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
