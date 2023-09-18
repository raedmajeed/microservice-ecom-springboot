package com.raedmajeed.inventoryservice.Service;

import com.raedmajeed.inventoryservice.DTO.ProductResponse;
import com.raedmajeed.inventoryservice.DTO.ProductRequest;
import com.raedmajeed.inventoryservice.Entity.Product;
import com.raedmajeed.inventoryservice.Repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void addProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .productName(productRequest.getProductName())
                .productDescription(productRequest.getProductDescription())
                .productPrice(productRequest.getProductPrice())
                .build();
        log.info(String.format("%s", product));
        productRepository.save(product);
    }

    public List<ProductResponse> fetchAllProducts() {
        List<Product> productList = productRepository.findAll();
        log.info("Fetching all products");
        System.out.println(productList);
        return productList.stream().map(this::toProduct).toList();
    }

    public ProductResponse toProduct(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .productDescription(product.getProductDescription())
                .productPrice(product.getProductPrice())
                .build();
    }
}
