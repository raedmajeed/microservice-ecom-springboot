package com.raedmajeed.inventoryservice.Service;

import com.raedmajeed.inventoryservice.Dto.InventoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryResponse inventoryResponse;
    @Override
    public boolean inventoryCheckStatus(List<String> skus) {
        System.out.println(skus);
        System.out.println("=====================");
        return true;
    }
}
