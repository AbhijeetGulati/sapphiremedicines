package com.sapphiremedicines.website.service.impl;

import com.sapphiremedicines.website.entity.Order;
import com.sapphiremedicines.website.repository.OrderRepository;
import com.sapphiremedicines.website.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
}
