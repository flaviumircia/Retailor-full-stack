package com.flaviumircia.pibd_app.controllers;

import com.flaviumircia.pibd_app.models.Client;
import com.flaviumircia.pibd_app.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clients/")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ModelAndView getClients(){
        ModelAndView mav=new ModelAndView("list-clients");
        List<Client> list=clientService.getClients();
        mav.addObject("clients",list);
        return mav;
    }
    @PostMapping
    public void registerClient(@RequestBody Client client){
        clientService.addNewClient(client);
    }
    @DeleteMapping(path = "{clientID}")
    public void deleteAClient(@PathVariable("clientID") Long id){
        clientService.deleteClient(id);
    }
    @PutMapping(path = "{clientID}")
    public void updateAClient(@PathVariable("clientID") Long id,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String address,
                              @RequestParam(required = false) String city,
                              @RequestParam(required = false) String zipcode,
                              @RequestParam(required = false) String phone_no){
        clientService.updateClient(id,name,address,city,zipcode,phone_no);
    }
}
