package com.flaviumircia.pibd_app.services;

import com.flaviumircia.pibd_app.models.Client;
import com.flaviumircia.pibd_app.models.Orders;
import com.flaviumircia.pibd_app.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public List<Orders> getOrders(){
        return orderRepository.findAll();
    }

    public void addOrder(Orders order) {
        orderRepository.save(order);
    }
    public void deleteOrder(Long id){
        boolean exists=orderRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Orders with number: "+id.toString() + "doesn't exist!");
        }
        orderRepository.deleteById(id);
    }
    @Transactional
    public void modifyOrder(Long id,String item_title,String item_description,int quantity,double unit_price){
        Orders order = orderRepository.findById(id).orElseThrow(()->new IllegalStateException("Order with id" + id.toString() + "does not exists!"));
        if(item_title!=null && item_title.length()>0 && !Objects.equals(order.getItem_title(),item_title)){
            order.setItem_title(item_title);
        }
        if(item_description!=null && item_description.length()>0 && !Objects.equals(order.getItem_description(),item_description)){
            order.setItem_description(item_description);
        }
        if(quantity>=0){
            order.setQuantity(quantity);
        }
        if(unit_price>=0){
            order.setUnit_price(unit_price);
        }
    }

}
