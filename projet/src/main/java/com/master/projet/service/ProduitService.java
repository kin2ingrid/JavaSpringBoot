package com.master.projet.service;

import org.hibernate.mapping.List;

import com.master.projet.model.Produit;

public interface ProduitService {

    public Produit saveProduit(Produit produit);
    public java.util.List<Produit> getAllProduits();

}