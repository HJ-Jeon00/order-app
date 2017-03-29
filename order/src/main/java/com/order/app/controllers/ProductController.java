package com.order.app.controllers;

import com.order.app.models.Product;
import com.order.app.models.ProductsResponse;
import com.order.app.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Joel.Gonzales on 3/29/2017.
 */
@RestController
@Api(value = "", description = "the  API")
public class ProductController {

  private ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @RequestMapping(value = "/browse",
    produces = {"application/json;charset=UTF-8"},
    method = RequestMethod.POST)
  @ApiOperation(value = "Browse products.", notes = "", response = Boolean.class, tags =
    {"Product Details",})
  public ResponseEntity<ProductsResponse> browse(@ApiParam(value = "Product type") @RequestParam(value = "type") String type) {
    ProductsResponse productsResponse = productService.browse(type);
    return new ResponseEntity<ProductsResponse>(productsResponse, HttpStatus.OK);
  }

  @RequestMapping(value = "/add",
    produces = {"application/json;charset=UTF-8"},
    method = RequestMethod.POST)
  @ApiOperation(value = "Browse products.", notes = "", response = Boolean.class, tags =
    {"Product Details",})
  public ResponseEntity<Boolean> add(@ApiParam(value = "Product ID")
                                                @RequestParam(value = "product_id") Integer product_id,
                                              @ApiParam(value = "Product name")
                                                @RequestParam(value = "name") String name,
                                              @ApiParam(value = "Product type")
                                                @RequestParam(value = "type") String type,
                                              @ApiParam(value = "Product description")
                                                @RequestParam(value = "description") String description) {
    Product product = new Product();
    product.setProduct_id(product_id);
    product.setName(name);
    product.setType(type);
    product.setDescription(description);
    productService.add(product);
    boolean result = true;
    return new ResponseEntity<Boolean>(result, HttpStatus.OK);
  }

  @RequestMapping(value = "/update",
    produces = {"application/json;charset=UTF-8"},
    method = RequestMethod.POST)
  @ApiOperation(value = "Browse products.", notes = "", response = Boolean.class, tags =
    {"Product Details",})
  public ResponseEntity<Boolean> update(@ApiParam(value = "Product ID")
                                     @RequestParam(value = "product_id") Integer product_id,
                                     @ApiParam(value = "Product name")
                                     @RequestParam(value = "name") String name,
                                     @ApiParam(value = "Product type")
                                     @RequestParam(value = "type") String type,
                                     @ApiParam(value = "Product description")
                                     @RequestParam(value = "description") String description) {
    Product product = new Product();
    product.setProduct_id(product_id);
    product.setName(name);
    product.setType(type);
    product.setDescription(description);
    productService.update(product);
    boolean result = true;
    return new ResponseEntity<Boolean>(result, HttpStatus.OK);
  }

  @RequestMapping(value = "/delete",
    produces = {"application/json;charset=UTF-8"},
    method = RequestMethod.POST)
  @ApiOperation(value = "Browse products.", notes = "", response = Boolean.class, tags =
    {"Product Details",})
  public ResponseEntity<Boolean> delete(@ApiParam(value = "Product ID")
                                        @RequestParam(value = "product_id") Integer product_id) {
    productService.delete(product_id);
    boolean result = true;
    return new ResponseEntity<Boolean>(result, HttpStatus.OK);
  }
}
