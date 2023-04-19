package com.mongo.test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mongo.test.model.Product;


@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {

   @Query(value="{'_id' : ?0}", delete = true)
   public Product deleteByProductId(int id);
   
   @Query(value="{'pname' : ?0}")
   public Product findByProductName(String name);
   
}
