package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Fournisseur;

public interface IFournisseurService {
	List<Fournisseur> retrieveAllFournisseurs();
	Fournisseur addFournisseur (Fournisseur f);
	Fournisseur updateFournisseur (Fournisseur f);
	Fournisseur retrieveFournisseur (Long id);
}
