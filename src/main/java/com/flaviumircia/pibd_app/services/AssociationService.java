package com.flaviumircia.pibd_app.services;

import com.flaviumircia.pibd_app.models.Association;
import com.flaviumircia.pibd_app.repositories.AssociationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociationService {
    private final AssociationRepository associationRepository;

    @Autowired
    public AssociationService(AssociationRepository associationRepository) {
        this.associationRepository = associationRepository;
    }

    public List<Association> getAll(){return associationRepository.findAll();}

}
