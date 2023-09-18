package com.raedmajeed.inventoryservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "inventory_table"
)
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String productSku;
    private int quantity;

}
