package com.raedmajeed.orderservice.Controller;

import com.raedmajeed.orderservice.DTO.OrderRequest;
import com.raedmajeed.orderservice.Service.OrderServiceImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@Tag(
        name = "Order API",
        description = "API to control order services"
)
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    @TimeLimiter(name = "inventory")
    @Retry(name = "inventory")
    public CompletableFuture<String> createOrder(@RequestBody OrderRequest orderRequest) {
        orderService.createOrder(orderRequest);
        return CompletableFuture.supplyAsync(() -> "Order placed Successfully");
    }
    public CompletableFuture<String> fallbackMethod(OrderRequest orderRequest, RuntimeException runtimeException) {
        return CompletableFuture.supplyAsync(() -> "OOPS something went wrong, place order after some time");
    }
}
