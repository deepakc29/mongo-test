package com.mongo.test.service;

import java.util.List;
import java.util.Optional;

import com.mongo.test.model.Product;

public interface IProductService {

   List<Product> findAllProduct();
   
   List<Product> addProduct(List<Product> products);
   
   Product deleteByProductId(int productId);
   
   public Optional<Product> findByProductId(int productId);
   
   public Product findByProductName(String productName);

}
