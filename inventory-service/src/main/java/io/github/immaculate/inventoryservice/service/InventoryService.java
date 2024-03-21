package io.github.immaculate.inventoryservice.service;


import io.github.immaculate.inventoryservice.model.InventoryCreateDto;
import io.github.immaculate.inventoryservice.model.InventoryResponse;

public interface InventoryService {

    InventoryResponse createInventory(InventoryCreateDto inventoryCreateDto);

}