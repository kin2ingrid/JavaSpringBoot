package com.master.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master.projet.model.Produit;
import com.master.projet.repository.ProduitRepository;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    // Méthode pour obtenir tous les produits
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    // Méthode pour obtenir un produit par son ID
    public Produit getProduitById(Long id) {
        return produitRepository.findById(id)
                .orElseThrow();
    }

    // Méthode pour sauvegarder ou mettre à jour un produit
    public Produit saveOrUpdateProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    // Méthode pour supprimer un produit par son ID
    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }

}
