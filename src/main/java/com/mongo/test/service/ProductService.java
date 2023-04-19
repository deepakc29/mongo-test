package com.mongo.test.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.test.model.Product;
import com.mongo.test.repository.ProductRepository;

@Service
public class ProductService implements IProductService {

   static List<Product> products = new CopyOnWriteArrayList<Product>();

   @Autowired
   private ProductRepository repository;

   static {
      products.add(new Product(100, "Mobile", "CLK98123", 9000.00, 6));
      products.add(new Product(101, "Smart TV", "LGST09167", 60000.00, 3));
      products.add(new Product(102, "Washing Machine", "38753BK9", 9000.00, 7));
      products.add(new Product(103, "Laptop", "LHP29OCP", 24000.00, 1));
      products.add(new Product(104, "Air Conditioner", "ACLG66721", 30000.00, 5));
      products.add(new Product(105, "Refrigerator ", "12WP9087", 10000.00, 4));
   }

   @Override
   public List<Product> findAllProduct() {
      return repository.findAll();
   }

   @Override
   public List<Product> addProduct(List<Product> products) {
      return repository.saveAll(products);
   }

   @Override
   public Product deleteByProductId(int productId) {
      return repository.deleteByProductId(productId);
   }

   @Override
   public Optional<Product> findByProductId(int productId) {
      return repository.findById(productId);
   }
   
   @Override
   public Product findByProductName(String productName) {
      return repository.findByProductName(productName);
   }

}
