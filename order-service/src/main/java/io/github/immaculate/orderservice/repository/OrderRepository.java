package io.github.immaculate.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.immaculate.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>{

    
}
