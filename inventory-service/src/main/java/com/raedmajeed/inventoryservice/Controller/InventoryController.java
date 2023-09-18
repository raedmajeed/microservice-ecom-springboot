package com.raedmajeed.inventoryservice.Controller;

import com.raedmajeed.inventoryservice.Service.InventoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryServiceImpl inventoryService;
    @GetMapping
    public boolean inventoryStatus(@RequestParam("skus") List<String> skuCodes) {
        return inventoryService.inventoryCheckStatus(skuCodes);
    }
}
