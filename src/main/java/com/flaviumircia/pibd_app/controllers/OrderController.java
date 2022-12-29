package com.flaviumircia.pibd_app.controllers;

import com.flaviumircia.pibd_app.models.Client;
import com.flaviumircia.pibd_app.models.Orders;
import com.flaviumircia.pibd_app.repositories.ClientRepository;
import com.flaviumircia.pibd_app.services.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
    public ModelAndView getOrders(){
        ModelAndView mav=new ModelAndView("list-order");
        List<Orders> list=orderService.getOrders();
        mav.addObject("orders",list);
        return mav;
    }
    @GetMapping("add/")
    public ModelAndView addNewOrderForm(){
        ModelAndView mav=new ModelAndView("add-order");
        Orders orders=new Orders();
        mav.addObject("order",orders);
        return mav;
    }
    @PostMapping(path="add/save/")
    public RedirectView registerOrder(@ModelAttribute Orders order){
        orderService.addOrder(order);
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl("http://localhost:8080/api/v1/orders/add/");
        return redirectView;
    }
    @DeleteMapping(path="{order_id}")
    public void deleteOrder(@PathVariable ("order_id") Long id){
        orderService.deleteOrder(id);
    }
    @GetMapping("update/{clientID}")
    public ModelAndView updateClient(){
        ModelAndView mav=new ModelAndView("put-order");
        Orders orders=new Orders();
        mav.addObject("order",orders);
        return mav;
    }
    @PostMapping(path ="update/{order_id}")
    public RedirectView modifyOrder(@PathVariable ("order_id") Long id,
                            @ModelAttribute Orders orders
                            ) {

        orderService.modifyOrder(id,orders.getItem_title(), orders.getItem_description(), orders.getQuantity(), orders.getUnit_price());
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl("http://localhost:8080/api/v1/orders/");
        return redirectView;
    }
}
