package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Facture;

public interface IFactureService {
	List<Facture> retrieveAllFactures();
	void cancelFacture(Long id);
	Facture retrieveFacture(Long id);
	List<Facture> getFacturesByFournisseur(Long idFournisseur);
	Facture addFacture(Facture f, Long idFournisseur);
}
