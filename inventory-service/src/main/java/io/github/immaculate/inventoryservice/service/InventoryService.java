package io.github.immaculate.inventoryservice.service;


import java.util.List;

import io.github.immaculate.inventoryservice.model.InventoryCreateDto;
import io.github.immaculate.inventoryservice.model.InventoryResponse;

public interface InventoryService {

    InventoryResponse createInventory(InventoryCreateDto inventoryCreateDto);

    Boolean checkInventory(List<String> productCodes, List<Integer> productQuantities);

}