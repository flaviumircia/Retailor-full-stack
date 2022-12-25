package com.flaviumircia.pibd_app.controllers;

import com.flaviumircia.pibd_app.pojos.AssociationPojo;
import com.flaviumircia.pibd_app.services.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String getAssoc(){
        StringBuilder sb=new StringBuilder();
        List<AssociationPojo[]> list=associationService.getAll();
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.get(i).length;j++) {
                sb.append(list.get(i)[j].toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }


}
