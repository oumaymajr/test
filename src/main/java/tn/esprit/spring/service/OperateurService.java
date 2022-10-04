package tn.esprit.spring.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Operateur;
import tn.esprit.spring.repository.FactureRepository;
import tn.esprit.spring.repository.OperateurRepository;
@Service
public class OperateurService implements IOperateurService{
	@Autowired
	OperateurRepository operateurRepository;
	@Autowired
	FactureRepository factureRepository;
	@Override
	public List<Operateur> retrieveAllOperateurs() {
		return (List<Operateur>) operateurRepository.findAll();
	}

	@Override
	public Operateur addOperateur(Operateur o) {
		return operateurRepository.save(o);
	}

	@Override
	public Operateur updateOperateur(Operateur o) {
		return operateurRepository.save(o);
	}

	@Override
	public Operateur retrieveOperateur(Long id) {
		return operateurRepository.findById(id).orElse(null);
	}

	@Override
	public void removeOperateur(Long id) {
		operateurRepository.deleteById(id);
	}
	@Override
	public void assignOperateurToFacture(Long idOperateur, Long idFacture) {
		// TODO Auto-generated method stub
		Facture f = factureRepository.findById(idFacture).orElse(null);
		Operateur o = operateurRepository.findById(idOperateur).orElse(null);
		Set <Facture> fact = o.getFactures();
		fact.add(f);
		o.setFactures(fact);
		operateurRepository.save(o);
	}
}
