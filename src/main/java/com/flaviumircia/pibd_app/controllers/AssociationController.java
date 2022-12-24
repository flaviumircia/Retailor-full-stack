package com.flaviumircia.pibd_app.controllers;

import com.flaviumircia.pibd_app.models.Association;
import com.flaviumircia.pibd_app.services.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/assoc/")
public class AssociationController {
    private final AssociationService associationService;

    @Autowired
    public AssociationController(AssociationService associationService) {
        this.associationService = associationService;
    }

    @GetMapping
    public List<Association> getAssoc(){return associationService.getAll();}

}
