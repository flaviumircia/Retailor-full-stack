package com.flaviumircia.pibd_app.configurations;

import com.flaviumircia.pibd_app.models.Orders;
import com.flaviumircia.pibd_app.repositories.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OrderConfig {
    @Bean("second")
    CommandLineRunner commandLineRunner(OrderRepository orderRepository){
        return args -> {
            Orders first_order= new Orders("Caciula","Caciula imblanita",2,25.00);
            Orders second_order= new Orders("Palton","Palton de lana",1,450.99);
//            orderRepository.saveAll(List.of(first_order,second_order));
        };
    }
}
