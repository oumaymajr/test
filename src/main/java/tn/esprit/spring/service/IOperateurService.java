package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Operateur;

public interface IOperateurService {
	List<Operateur> retrieveAllOperateurs();

	Operateur addOperateur (Operateur o);

	Operateur updateOperateur (Operateur o);

	Operateur retrieveOperateur (Long id);

	void removeOperateur (Long id);

	void assignOperateurToFacture(Long idOperateur, Long idFacture);


}
