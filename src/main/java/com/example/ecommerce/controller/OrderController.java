package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Order;
import com.example.ecommerce.service.OrderService;
import jakarta.validation.Valid;
import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public List<Order> getAll(){
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public Order getOrderId(@PathVariable Integer id){
        return orderService.getOrderByID(id);
    }

    @PostMapping("/orders")
    public Order createOrder(@Valid @RequestBody Order order){
        return orderService.addOrder(order);
    }

    @PutMapping("/orders/{id}")
    public Order updateOrder(@Valid @PathVariable Integer id, @RequestBody Order order){
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable Integer id){
         orderService.deleteOrder(id);
    }
}
