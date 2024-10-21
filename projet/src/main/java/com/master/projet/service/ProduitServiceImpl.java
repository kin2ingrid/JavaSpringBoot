package com.master.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master.projet.model.Produit;
import com.master.projet.repository.ProduitRepository;


@Service
public class ProduitServiceImpl implements ProduitService {
  
    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public Produit saveProduit(Produit produit) {
        return produitRepository.save(produit) ;
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    
    

}
