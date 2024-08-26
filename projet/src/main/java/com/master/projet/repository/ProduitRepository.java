package com.master.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.master.projet.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
