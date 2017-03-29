package com.order.app.mappers;

import com.order.app.models.Product;
import com.order.app.models.display.ProductDisplayData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joel.Gonzales on 3/29/2017.
 */
@Component
public class ProductDisplayDataMapper {

  public List<ProductDisplayData> map(List<Product> products) {
    List<ProductDisplayData> productDisplayDatas = new ArrayList<ProductDisplayData>();
    for(Product product : products) {
      ProductDisplayData productDisplayData = new ProductDisplayData();
      productDisplayData.setProductId(product.getProduct_id());
      productDisplayData.setProductName(product.getName());
      productDisplayData.setProductType(product.getType());
      productDisplayData.setProductDescription(product.getDescription());
      productDisplayDatas.add(productDisplayData);
    }
    return productDisplayDatas;
  }
}
