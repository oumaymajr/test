package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.SecteurActivite;

public interface ISecteurActiviteService {
	List<SecteurActivite> retrieveAllSecteurActivites();

	SecteurActivite addSecteurActivite (SecteurActivite sa);

	SecteurActivite updateSecteurActivite (SecteurActivite sa);

	SecteurActivite retrieveSecteurActivite (Long id);

	void removeSecteurActivite (Long id);

	void assignSecteurActiviteToFournisseur(Long fournisseurId, Long secteurActiviteId);
}
