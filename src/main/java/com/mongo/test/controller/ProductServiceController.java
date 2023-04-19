package com.mongo.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.test.model.Product;
import com.mongo.test.service.IProductService;

@RestController
public class ProductServiceController {

   @Autowired
   private IProductService productService;

   @GetMapping(value = "/get/products")
   public ResponseEntity<Object> getProduct() {
      return new ResponseEntity<Object>(productService.findAllProduct(), HttpStatus.OK);
   }

   @PostMapping(value = "/add/products")
   public ResponseEntity<Object> addProduct(@RequestBody
   List<Product> products) {
      return new ResponseEntity<Object>(productService.addProduct(products), HttpStatus.CREATED);
   }

   @DeleteMapping(value = "/delete/products/{id}")
   public ResponseEntity<Object> deleteProduct(@PathVariable
   int id) {
      return new ResponseEntity<Object>(productService.deleteByProductId(id), HttpStatus.NO_CONTENT);
   }

   @GetMapping(value = "/getbyid/products/{id}")
   public ResponseEntity<Object> findByProductId(@PathVariable
   int id) {
      return new ResponseEntity<Object>(productService.findByProductId(id), HttpStatus.OK);
   }

   @GetMapping(value = "/getbyname/products/{name}")
   public ResponseEntity<Object> findByProductName(@PathVariable
   String name) {
      return new ResponseEntity<Object>(productService.findByProductName(name), HttpStatus.UNAUTHORIZED);
   }

}
