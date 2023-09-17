package com.raedmajeed.productservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    String id;
    String productName;
    String productDescription;
    BigInteger productPrice;
}
