package com.raedmajeed.orderservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private int Id;
    private String productSku;
    private BigInteger productPrice;
    private int productQty;
}
