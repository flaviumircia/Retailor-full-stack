package com.flaviumircia.pibd_app.controllers;

import com.flaviumircia.pibd_app.models.Association;
import com.flaviumircia.pibd_app.models.Client;
import com.flaviumircia.pibd_app.pojos.AssociationPojo;
import com.flaviumircia.pibd_app.services.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void registerClientAndOrder(@RequestBody Association association){
        associationService.addAssociation(association);
    }
    @DeleteMapping(path = "{association_id}")
    public void deleteAssociationById(@PathVariable("association_id") Long id){
        associationService.deleteById(id);
    }

//TODO: PUTMAPPING

    @PutMapping(path = "{association_id}")
    public void updateAssociationById(@PathVariable("association_id") Long id,
                                      @RequestBody Association association){
        associationService.updateById(id,association);
    }
}
