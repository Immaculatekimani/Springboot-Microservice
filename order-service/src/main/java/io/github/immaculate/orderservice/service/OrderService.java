package io.github.immaculate.orderservice.service;

import io.github.immaculate.orderservice.model.OrderRequest;

public interface OrderService {

    void placeOrder(OrderRequest orderRequest);

}