package tn.esprit.spring.service;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.DetailFournisseur;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.entity.SecteurActivite;
import tn.esprit.spring.repository.DetailFournisseurRepository;
import tn.esprit.spring.repository.FactureRepository;
import tn.esprit.spring.repository.FournisseurRepository;
import tn.esprit.spring.repository.SecteurActiviteRepository;
@Service
public class FournisseurService implements IFournisseurService{
	@PersistenceContext
    private EntityManager em;
	@Autowired
	FournisseurRepository fournisseurRepository;
	@Autowired
	DetailFournisseurRepository detailFournisseurRepository;
	@Autowired
	SecteurActiviteRepository secteurActiviteRepository;
	@Autowired
	FactureRepository factureRepository;
	@Override
	public List<Fournisseur> retrieveAllFournisseurs() {
		// TODO Auto-generated method stub
		return (List<Fournisseur>) fournisseurRepository.findAll();
	}

	@Override
	public Fournisseur addFournisseur(Fournisseur f) {
		DetailFournisseur df=new DetailFournisseur();
		df.setFournisseur(f);
		f.setDetailfournisseur(detailFournisseurRepository.save(df));
		return fournisseurRepository.save(f);
	}

	@Override
	public Fournisseur updateFournisseur(Fournisseur f) {
		// TODO Auto-generated method stub
		return fournisseurRepository.save(f);
	}

	@Override
	public Fournisseur retrieveFournisseur(Long id) {
		// TODO Auto-generated method stub
		return fournisseurRepository.findById(id).orElse(null);
	}

	


}
