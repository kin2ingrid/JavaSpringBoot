package com.master.projet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.master.projet.model.Produit;
import com.master.projet.service.ProduitService;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping("/liste")
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
        try {
            Produit produit = produitService.getProduitById(id);
            return ResponseEntity.ok().body(produit);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.saveOrUpdateProduit(produit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody Produit produitDetails) {
        try {
            Produit produit = produitService.getProduitById(id);

            produit.setName(produitDetails.getName());
            produit.setDescription(produitDetails.getDescription());
            produit.setPrice(produitDetails.getPrice());

            final Produit updatedProduit = produitService.saveOrUpdateProduit(produit);
            return ResponseEntity.ok(updatedProduit);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
