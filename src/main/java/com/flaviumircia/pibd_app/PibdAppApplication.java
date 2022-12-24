package com.flaviumircia.pibd_app;

import com.flaviumircia.pibd_app.models.Client;
import com.flaviumircia.pibd_app.repositories.ClientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class PibdAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(PibdAppApplication.class, args);
    }


}
