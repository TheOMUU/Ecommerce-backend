package com.example.ecommerce.service;

import com.example.ecommerce.entity.Order;
import com.example.ecommerce.exception.OrderNotFound;
import com.example.ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
    public Order getOrderByID(Integer id){
        return orderRepository.findById(id).orElseThrow(()-> new OrderNotFound("Order with id is not available"));
    }

    public Order addOrder(Order order){
        return orderRepository.save(order);
    }

    public Order updateOrder(Integer id, Order updatedOrder){
        Order existingOrder = orderRepository.findById(id).orElseThrow(()-> new OrderNotFound("Order with Id is not found"));
        existingOrder.setAddress(updatedOrder.getAddress());
        existingOrder.setCountry(updatedOrder.getCountry());
        existingOrder.setState(updatedOrder.getState());
        existingOrder.setEmail(updatedOrder.getEmail());

        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(Integer id){
        orderRepository.deleteById(id);
    }
}
