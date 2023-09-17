package com.raedmajeed.productservice.Controller;


import com.raedmajeed.productservice.DTO.ProductRequest;
import com.raedmajeed.productservice.DTO.ProductResponse;
import com.raedmajeed.productservice.Service.ProductService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.event.ListDataEvent;
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
