package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.CategorieProduit;

public interface ICategorieProduitService {
	List<CategorieProduit> retrieveAllCategorieProduits();

	CategorieProduit addCategorieProduit(CategorieProduit cp);

	CategorieProduit updateCategorieProduit(CategorieProduit cp);

	CategorieProduit retrieveCategorieProduit(Long id);

	void removeCategorieProduit(Long id);
}
