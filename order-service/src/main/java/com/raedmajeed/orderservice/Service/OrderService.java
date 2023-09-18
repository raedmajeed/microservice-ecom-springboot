package com.raedmajeed.orderservice.Service;

import com.raedmajeed.orderservice.DTO.OrderRequest;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    public void createOrder(OrderRequest orderRequest);
}
