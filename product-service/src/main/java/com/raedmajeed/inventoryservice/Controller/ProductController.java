package com.raedmajeed.inventoryservice.Controller;


import com.raedmajeed.inventoryservice.DTO.ProductResponse;
import com.raedmajeed.inventoryservice.Service.ProductService;
import com.raedmajeed.inventoryservice.DTO.ProductRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@Tag(name = "dig", description = "this is product addidtion")
public class ProductController {

    @Autowired
    private ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.addProduct(productRequest);
    }

    @GetMapping()
    public ResponseEntity<List<ProductResponse>> fetchAll() {
        return ResponseEntity.ok(productService.fetchAllProducts());
    }

}
