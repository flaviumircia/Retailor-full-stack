package com.flaviumircia.pibd_app.controllers;

import com.flaviumircia.pibd_app.models.Client;
import com.flaviumircia.pibd_app.models.Orders;
import com.flaviumircia.pibd_app.repositories.ClientRepository;
import com.flaviumircia.pibd_app.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders/")
public class OrderController {
    private final OrderService orderService;
    private final ClientRepository clientRepository;
    private Client client;
    @Autowired
    public OrderController(OrderService orderService, ClientRepository clientRepository) {
        this.orderService = orderService;
        this.clientRepository = clientRepository;
    }
    @GetMapping
    public List<Orders> getOrders(){
        return orderService.getOrders();
    }
    @PostMapping(path="add/{client_id}")
    public void registerOrder(@RequestBody Orders order){
        orderService.addOrder(order);
    }
    @DeleteMapping(path="{order_id}")
    public void deleteOrder(@PathVariable ("order_id") Long id){
        orderService.deleteOrder(id);
    }
    @PutMapping(path ="{order_id}")
    public void modifyOrder(@PathVariable ("order_id") Long id,
                            @RequestParam String item_title,
                            @RequestParam String item_description,
                            @RequestParam Integer quantity,
                            @RequestParam Double unit_price
                            ) {

        orderService.modifyOrder(id,item_title,item_description,quantity,unit_price);
    }
}
