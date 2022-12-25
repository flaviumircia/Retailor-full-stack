package com.flaviumircia.pibd_app.services;

import com.flaviumircia.pibd_app.models.Association;
import com.flaviumircia.pibd_app.models.Client;
import com.flaviumircia.pibd_app.pojos.AssociationPojo;
import com.flaviumircia.pibd_app.repositories.AssociationRepository;
import com.flaviumircia.pibd_app.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    public List<AssociationPojo[]> getAll(){
        return associationRepository.findAllSumarized();}

    public void addAssociation(Association association) {
        Client client=association.getClient();
        Pageable first = PageRequest.of(0, 1);
        List<Client> clientByEmail= clientRepository.findFirstClientByEmail(client.getEmail(),first);
        if(clientByEmail.isEmpty()){
            throw new IllegalStateException("Client is not registered!\n Please register first then add a new order!");
        }
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
}
