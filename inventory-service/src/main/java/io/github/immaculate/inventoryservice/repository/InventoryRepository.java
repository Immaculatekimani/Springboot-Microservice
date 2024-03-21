package io.github.immaculate.inventoryservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.immaculate.inventoryservice.entity.Inventory;

import java.util.Optional;

public interface InventoryRepository extends MongoRepository<Inventory,String>{
    Optional<Inventory> findByProductCode(String productCode);

}
