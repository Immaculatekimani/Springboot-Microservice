package io.github.immaculate.inventoryservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.immaculate.inventoryservice.entity.Inventory;

public interface InventoryRepository extends MongoRepository<Inventory,String>{

}
