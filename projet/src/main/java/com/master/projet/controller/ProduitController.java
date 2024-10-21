package com.master.projet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.master.projet.model.Produit;
import com.master.projet.service.ProduitService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController

@RequestMapping("/produit")
@CrossOrigin
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @PostMapping("/ajouter")
    public String ajouter(@RequestBody Produit produit) {
        produitService.saveProduit(produit);
        
        return "Produit ajouter";
    }

    @GetMapping("/liste")
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }
    


    
}