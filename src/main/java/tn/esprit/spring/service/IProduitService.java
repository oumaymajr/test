package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Produit;

public interface IProduitService {
	List<Produit> retrieveAllProduits();
	List<Produit> retrieveAllProduitsByCreation();
	Produit addProduit (Produit p, Long idCategorieProduit, Long idStock);

	Produit updateProduit (Produit p, Long idCategorieProduit, Long idStock);

	Produit retrieveProduit(Long id);
	void assignProduitToStock(Long idProduit, Long idStock);
}
