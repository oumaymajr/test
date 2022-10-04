package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.DetailFacture;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.repository.DetailFactureRepository;
import tn.esprit.spring.repository.DetailFournisseurRepository;
import tn.esprit.spring.repository.FactureRepository;
import tn.esprit.spring.repository.FournisseurRepository;
import tn.esprit.spring.repository.OperateurRepository;
import tn.esprit.spring.repository.ReglementRepository;
@Service
public class FactureService implements IFactureService{
	@Autowired
	FactureRepository factureRepository;
	@Autowired
	OperateurRepository operateurRepository;
	@Autowired
	FournisseurRepository fournisseurRepository;
	@Autowired
	ReglementRepository reglementRepository;
	@Autowired
	DetailFactureRepository detailFactureRepository;
	@Override
	public List<Facture> retrieveAllFactures() {
		// TODO Auto-generated method stub
		return (List<Facture>) factureRepository.findAll();
	}

	@Override
	public void cancelFacture(Long id) {
		// TODO Auto-generated method stub
		Facture f= factureRepository.findById(id).orElse(null);
		if(f!=null) {
			f.setArchivee(true);
			factureRepository.save(f);
		}
	}

	@Override
	public Facture retrieveFacture(Long id) {
		// TODO Auto-generated method stub
		return factureRepository.findById(id).orElse(null);
	}
	@Override
	public List<Facture> getFacturesByFournisseur(Long idFournisseur) {
		Fournisseur fournisseur = fournisseurRepository.findById(idFournisseur).orElse(null);
		// TODO Auto-generated method stub
		return factureRepository.getFacturesByFournisseur(fournisseur);
	}
	@Override
	public Facture addFacture(Facture f, Long idFournisseur) {
		Fournisseur fourn = fournisseurRepository.findById(idFournisseur).orElse(null);
		float sum=0;
		float remise=0;
		for(DetailFacture df : f.getDetailfacture()) {
			float val=df.getQteCommandee()*df.getProduit().getPrix();
			df.setPrixTotalDetail(val);
			sum+=val;
			val *= df.getPourcentageRemise()/100;
			df.setMontantRemise(val);
			remise+=val;
			detailFactureRepository.save(df);
		}
		f.setMontantFacture(sum);
		f.setMontantRemsie(remise);
		f.setFournisseur(fourn);
		return factureRepository.save(f);
	}
	

}
