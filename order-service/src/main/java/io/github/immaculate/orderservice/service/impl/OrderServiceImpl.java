package io.github.immaculate.orderservice.service.impl;

import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import io.github.immaculate.orderservice.entity.Order;
import io.github.immaculate.orderservice.entity.OrderItem;
import io.github.immaculate.orderservice.model.OrderItemRequest;
import io.github.immaculate.orderservice.model.OrderRequest;
import io.github.immaculate.orderservice.repository.OrderRepository;
import io.github.immaculate.orderservice.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }

    @Override
    public void placeOrder(OrderRequest orderRequest) {
       Order order = new Order();
       order.setOrderNumber(UUID.randomUUID().toString());
       order.setOrderTime(Instant.now());
       var orderItems = orderRequest.getOrderItems().stream().map(this::mapToOrderItemEntity).toList();
       order.setOrderItems(orderItems);
       orderRepository.save(order);
    }
    private OrderItem mapToOrderItemEntity(OrderItemRequest itemRequest){
        OrderItem orderItem = new OrderItem();
        BeanUtils.copyProperties(itemRequest, orderItem);
        return orderItem;
    }

}