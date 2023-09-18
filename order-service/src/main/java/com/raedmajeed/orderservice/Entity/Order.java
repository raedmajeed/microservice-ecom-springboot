package com.raedmajeed.orderservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Table(
        name = "order_table"
)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int OrderId;
    @Column(nullable = false)
    private String orderNumber;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
           name = "order_id", referencedColumnName = "OrderId"
    )
    List<OrderLineItems> orderLineItemsList;
}
