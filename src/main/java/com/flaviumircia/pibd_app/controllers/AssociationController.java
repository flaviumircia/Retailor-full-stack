package com.flaviumircia.pibd_app.controllers;

import com.flaviumircia.pibd_app.models.Association;
import com.flaviumircia.pibd_app.models.Client;
import com.flaviumircia.pibd_app.pojos.AssociationPojo;
import com.flaviumircia.pibd_app.services.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/api/v1/assns/")
public class AssociationController {
    private final AssociationService associationService;

    @Autowired
    public AssociationController(AssociationService associationService) {
        this.associationService = associationService;
    }

    @GetMapping
    public ModelAndView getAssoc(){
        ModelAndView mav=new ModelAndView("list-associations");
        List<Association> list=associationService.getAll();
        mav.addObject("assn",list);
        return mav;
    }
    @GetMapping("add/")
    public ModelAndView addNewClientForm(){
        ModelAndView mav=new ModelAndView("add-assn");
        Association association=new Association();
        mav.addObject("association",association);
        return mav;
    }
    @PostMapping("add/save/")
    public RedirectView registerClient(@ModelAttribute Association association){
        associationService.addAssociation(association);
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl("http://localhost:8080/api/v1/assns/add/");
        return redirectView;
    }

    @DeleteMapping(path = "{association_id}")
    public void deleteAssociationById(@PathVariable("association_id") Long id){
        associationService.deleteById(id);
    }

    @GetMapping("update/{association_id}")
    public ModelAndView updateClient(){
        ModelAndView mav=new ModelAndView("put-assn");
        Association association=new Association();
        mav.addObject("assn",association);
        return mav;
    }
    @PostMapping(path = "update/{association_id}")
    public RedirectView updateAClient(@PathVariable("association_id") Long id,
                                      @ModelAttribute Association association){
        associationService.updateById(id,association);
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl("http://localhost:8080/api/v1/assns/");
        return redirectView;
    }

}
