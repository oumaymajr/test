package tn.esprit.spring.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Reglement;
import tn.esprit.spring.repository.FactureRepository;
import tn.esprit.spring.repository.ReglementRepository;

public class ReglementService implements IReglementService{

	@Autowired
	ReglementRepository reglementRepository;
	@Autowired
	FactureRepository factureRepository;
	@Override
	public List<Reglement> retrieveAllReglements() {
		// TODO Auto-generated method stub
		return (List<Reglement>) reglementRepository.findAll();
	}


	@Override
	public void deleteReglement(Long id) {
		// TODO Auto-generated method stub
		reglementRepository.deleteById(id);
	}

	@Override
	public Reglement updateReglement(Reglement s) {
		// TODO Auto-generated method stub
		return reglementRepository.save(s);
	}

	@Override
	public Reglement retrieveReglement(Long id) {
		// TODO Auto-generated method stub
		return reglementRepository.findById(id).orElse(null);
	}
	@Override
	public Set<Reglement> RetrieveReglementByFacture(Long idFacture) {
		Facture f = factureRepository.findById(idFacture).orElse(null);
		return  f.getReglements();
	}


	@Override
	public Reglement addReglement(Reglement r, Long idFacture) {
		Facture f = factureRepository.findById(idFacture).orElse(null);
		Set<Reglement> reg= this.RetrieveReglementByFacture(idFacture);
		float sum=0;
		for (Reglement g : reg) {
			if (g.isPayee()) {
				sum+=g.getMonatantPaye();
			}
		}
		if(sum+r.getMonatantPaye()<= f.getMontantFacture()) {
			r.setFacture(f);
			r.setMontantRestant(sum+r.getMonatantPaye()-f.getMontantFacture());
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			Date d= new Date(dtf.format(LocalDate.now()));
			f.setDateDerniereModification(d);
			return reglementRepository.save(r);
		}else {
			return r;
		}
	}


	@Override
	public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		List<Reglement> reg= reglementRepository.getChiffreAffaireEntreDeuxDate(startDate, endDate);
		float sum=0;
		for(Reglement r : reg) {
			if(!r.getFacture().isArchivee()) {
				sum+=r.getMonatantPaye();
			}
		}
		return sum;
	}


	@Override
	public float pourcentageRecouvrement(Date startDate, Date endDate) {
		List<Reglement> reg= reglementRepository.getChiffreAffaireEntreDeuxDate(startDate, endDate);
		List<String> s=new ArrayList<String>();
		for(Reglement r : reg) {
			if(!r.getFacture().isArchivee()) {
				s.add(r.getFacture().getIdFacture().toString());
			}
		}
		List<String> distinctElements = s.stream()
                .distinct()
                .collect(Collectors.toList());
		return reg.size()/distinctElements.size();
	}
	
}
