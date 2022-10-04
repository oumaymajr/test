package tn.esprit.spring.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.entity.SecteurActivite;
import tn.esprit.spring.repository.FournisseurRepository;
import tn.esprit.spring.repository.SecteurActiviteRepository;
@Service
public class SecteurActiviteService implements ISecteurActiviteService{
	@Autowired
	SecteurActiviteRepository secteurActiviteRepository;  
	@Autowired
	FournisseurRepository fournisseurRepository; 
	@Override
	public List<SecteurActivite> retrieveAllSecteurActivites() {
		return (List<SecteurActivite>) secteurActiviteRepository.findAll();
	}

	@Override
	public SecteurActivite addSecteurActivite(SecteurActivite sa) {
		return secteurActiviteRepository.save(sa);
	}

	@Override
	public SecteurActivite updateSecteurActivite(SecteurActivite sa) {
		return secteurActiviteRepository.save(sa);
	}

	@Override
	public SecteurActivite retrieveSecteurActivite(Long id) {
		// TODO Auto-generated method stub
		return secteurActiviteRepository.findById(id).orElse(null);
	}

	@Override
	public void removeSecteurActivite(Long id) {
		// TODO Auto-generated method stub
		secteurActiviteRepository.deleteById(id);
	}
	@Override
	public void assignSecteurActiviteToFournisseur(Long fournisseurId, Long secteurActiviteId) {
		
		Fournisseur f = fournisseurRepository.findById(fournisseurId).orElse(null);
		
		SecteurActivite sa = secteurActiviteRepository.findById(secteurActiviteId).orElse(null);
	
		Set <Fournisseur> four = sa.getFournisseurs();
		four.add(f);
		sa.setFournisseurs(four);
		secteurActiviteRepository.save(sa);
		
	}

}
