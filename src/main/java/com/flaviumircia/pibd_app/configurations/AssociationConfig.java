package com.flaviumircia.pibd_app.configurations;

import com.flaviumircia.pibd_app.models.Association;
import com.flaviumircia.pibd_app.models.Client;
import com.flaviumircia.pibd_app.models.Orders;
import com.flaviumircia.pibd_app.repositories.AssociationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AssociationConfig {
    @Bean("third")
    CommandLineRunner commandLineRunner(AssociationRepository associationRepository){
        return args -> {
            Client client_1=new Client("adrian",
                    "plaiaului",
                    "adrian@yahoo.com",
                    "Campina",
                    "Romania",
                    "88888",
                    "+88888888");
            Orders order_1=new Orders("patura","patura din bumbac",2,150.22);
            Orders order_2=new Orders("perna","perna din pene de gasca",3,100.55);
            Association association_1=new Association(client_1,order_1,"card");
            Association association_2=new Association(client_1,order_2,"card");
//            associationRepository.saveAll(List.of(association_1,association_2));
        };
    }
}
