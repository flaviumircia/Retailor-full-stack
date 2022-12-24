package com.flaviumircia.pibd_app.services;

import com.flaviumircia.pibd_app.models.Client;
import com.flaviumircia.pibd_app.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public void addNewClient(Client client) {
        Optional<Client > clientByEmail=
                clientRepository.findClientByEmail(client.getEmail());
        if(clientByEmail.isPresent()){
            throw new IllegalStateException("E-mail is already registered!");
        }
        clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        boolean exists=
                clientRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Client with ID: "+id+ " does NOT exists!");
        }
        clientRepository.deleteById(id);
    }
    @Transactional
    public void updateClient(Long id, String email, String name, String address, String city, String zipcode, String phone_no) {
        Client client=clientRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Client with the id = " + id +" does NOT exists"));
        if(email!=null && email.length()>0 && !Objects.equals(client.getEmail(),email)){
            Optional<Client> clientOptional=clientRepository.findClientByEmail(email);
            if(clientOptional.isPresent()){
                throw new IllegalStateException("email is already registered!");
            }
            client.setEmail(email);
        }
        if(name!=null && name.length()>0 && !Objects.equals(client.getName(),name)){
            client.setName(name);
        }
        if(address!=null && address.length()>0 && !Objects.equals(client.getAddress(),address)){
            client.setAddress(address);
        }
        if(city!=null && city.length()>0 && !Objects.equals(client.getCity(),city)){
            client.setCity(city);
        }
        if(zipcode!=null && zipcode.length()>0 && !Objects.equals(client.getZipcode(),zipcode))
            client.setZipcode(zipcode);
        if(phone_no!=null && phone_no.length()>0 && !Objects.equals(client.getPhone_no(),phone_no))
            client.setPhone_no(phone_no);
    }
}
