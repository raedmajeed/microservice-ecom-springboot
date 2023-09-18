package com.raedmajeed.orderservice.Service;

import com.raedmajeed.orderservice.DTO.OrderRequest;
import com.raedmajeed.orderservice.DTO.OrderResponse;
import com.raedmajeed.orderservice.Entity.Order;
import com.raedmajeed.orderservice.Entity.OrderLineItems;
import com.raedmajeed.orderservice.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    Order order = new Order();
    private final OrderRepository orderRepository;
    private final WebClient.Builder webClient;
    @Override
    public void createOrder(OrderRequest orderRequest) {
        order.setOrderNumber(UUID.randomUUID().toString());
        System.out.println(orderRequest);
        List<OrderLineItems> orderLineItemsList = orderRequest.getOrderLineItemsList().stream()
                .map(this::getOrderItem)
                .toList();
        order.setOrderLineItemsList(orderLineItemsList);

        List<String> skus = order.getOrderLineItemsList().stream().map(OrderLineItems::getProductSku).toList();

        boolean response = Boolean.TRUE.equals(webClient.build().get()
                .uri("http://inventory-service/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skus", skus).build())
                .retrieve()
                .bodyToMono(Boolean.class)
                .block());

        if (response) {
            orderRepository.save(order);
            log.info("Saved To Database");
        }

        System.out.println("hey=============================");
    }

    private OrderLineItems getOrderItem(OrderResponse order) {
        return OrderLineItems.builder()
                .productPrice(order.getProductPrice())
                .productSku(order.getProductSku())
                .productQty(order.getProductQty())
                .build();
    }
}
