package com.flaviumircia.pibd_app.controllers;

import com.flaviumircia.pibd_app.models.Client;
import com.flaviumircia.pibd_app.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
    @GetMapping("new_client/")
    public ModelAndView addNewClientForm(){
        ModelAndView mav=new ModelAndView("add-client");
        Client client=new Client();
        mav.addObject("client",client);
        return mav;
    }
    @PostMapping("new_client/save/")
    public RedirectView registerClient(@ModelAttribute Client client){
        clientService.addNewClient(client);
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl("http://localhost:8080/api/v1/clients/new_client/");
        return redirectView;
    }
    @DeleteMapping(path = "{clientID}")
    public RedirectView deleteAClient(@PathVariable("clientID") Long id){
        clientService.deleteClient(id);
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl("http://localhost:8080/api/v1/clients/");
        return redirectView;
    }
    @GetMapping("update/{clientID}")
    public ModelAndView updateClient(){
        ModelAndView mav=new ModelAndView("put-clients");
        Client client=new Client();
        mav.addObject("client",client);
        return mav;
    }
    @PostMapping(path = "update/{clientID}")
    public RedirectView updateAClient(@PathVariable("clientID") Long id,
                                @ModelAttribute Client new_client){
        clientService.updateClient(id,new_client.getName(), new_client.getAddress(), new_client.getCity(), new_client.getZipcode(), new_client.getPhone_no());
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl("http://localhost:8080/api/v1/clients/");
        return redirectView;
    }
}
