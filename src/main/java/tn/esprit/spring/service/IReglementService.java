package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import tn.esprit.spring.entity.Reglement;

public interface IReglementService {
	List<Reglement> retrieveAllReglements();

	Reglement addReglement(Reglement r, Long idFacture);

	void deleteReglement (Long id);

	Reglement updateReglement (Reglement s);

	Reglement retrieveReglement (Long id);

	Set<Reglement> RetrieveReglementByFacture(Long idFacture);
	float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
	float pourcentageRecouvrement(Date startDate, Date endDate);
}
