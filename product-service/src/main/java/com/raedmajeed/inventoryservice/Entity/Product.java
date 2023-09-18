package com.raedmajeed.inventoryservice.Entity;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;

@Document("Products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@OpenAPIDefinition(tags = {})
public class Product {

    @Id
    private String id;
    @Field("Name")
    @Indexed(unique = true)
    private String productName;
    @Field("Description")
    private String productDescription;
    @Field("Price")
    private BigInteger productPrice;
}

