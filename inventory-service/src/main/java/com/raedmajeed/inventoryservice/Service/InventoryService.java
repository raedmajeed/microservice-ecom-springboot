package com.raedmajeed.inventoryservice.Service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventoryService {

    boolean inventoryCheckStatus(List<String> skus);
}
