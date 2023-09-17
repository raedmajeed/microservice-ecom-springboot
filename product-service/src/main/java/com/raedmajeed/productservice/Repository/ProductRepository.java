package com.raedmajeed.productservice.Repository;

import com.raedmajeed.productservice.Entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

@org.springframework.stereotype.Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {
}
