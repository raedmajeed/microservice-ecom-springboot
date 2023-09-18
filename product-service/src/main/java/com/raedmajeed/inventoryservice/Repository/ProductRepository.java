package com.raedmajeed.inventoryservice.Repository;

import com.raedmajeed.inventoryservice.Entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

@org.springframework.stereotype.Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {
}
