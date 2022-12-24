package com.flaviumircia.pibd_app.configurations;

import com.flaviumircia.pibd_app.models.Client;
import com.flaviumircia.pibd_app.models.Orders;
import com.flaviumircia.pibd_app.repositories.ClientRepository;
import com.flaviumircia.pibd_app.repositories.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClientConfig {
    @Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository,OrderRepository orderRepository){
        return args -> {
            Client flaviu=new Client(
                    "flaviu",
                    "maniu",
                    "flaviumircia15@gmail.com",
                    "Bucharest",
                    "Romania",
                    "888888",
                    "+8888888888");
            Client andrei= new  Client(
                    "andrei",
                    "Veteranilor",
                    "andrei22@gmail.com",
                    "Bucharest",
                    "Romania",
                    "10768",
                    "+4076872256");
//            Orders first_order= new Orders("Caciula","Caciula imblanita",2,25.00);
//            orderRepository.saveAll(List.of(first_order));
//            flaviu.addOrder(first_order);
//            andrei.addOrder(first_order);
//
//            clientRepository.saveAll(List.of(flaviu,andrei));

        };
    }
}
