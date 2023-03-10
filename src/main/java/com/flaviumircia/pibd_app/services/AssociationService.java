package com.flaviumircia.pibd_app.services;

import com.flaviumircia.pibd_app.models.Association;
import com.flaviumircia.pibd_app.models.Client;
import com.flaviumircia.pibd_app.pojos.AssociationPojo;
import com.flaviumircia.pibd_app.repositories.AssociationRepository;
import com.flaviumircia.pibd_app.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociationService {
    private final AssociationRepository associationRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public AssociationService(AssociationRepository associationRepository,
                              ClientRepository clientRepository) {
        this.associationRepository = associationRepository;
        this.clientRepository = clientRepository;
    }

    public List<Association> getAll(){
        return associationRepository.findAll();}

    public void addAssociation(Association association) {
        Client client=association.getClient();
        Pageable first = PageRequest.of(0, 1);
        List<Client> clientByEmail= clientRepository.findFirstClientByEmail(client.getEmail(),first);
        associationRepository.save(association);
    }

    public void deleteById(Long id) {
        boolean checkIfExists=
                associationRepository.existsById(id);
        if(!checkIfExists){
            throw new IllegalStateException("The id:"+id+" does not exist in the database!");
        }
        associationRepository.deleteById(id);
    }

    @Transactional
    public void updateById(Long id, Association association) {
        Association checkIfExists=associationRepository.findById(id).orElseThrow(()->new RuntimeException("Association with id:"+id+" does not exists!"));
        if(association!=null && !association.getClient().equals(checkIfExists.getClient())){
            checkIfExists.setClient(association.getClient());
        }
        if(association!=null && !association.getOrders().equals(checkIfExists.getOrders())){
            checkIfExists.setOrders(association.getOrders());
        }
        if(association!=null && !association.getPayment().equals(checkIfExists.getPayment())){
            checkIfExists.setPayment(association.getPayment());
        }
    }
}
