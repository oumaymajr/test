package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Reglement;

public interface ReglementRepository extends CrudRepository<Reglement, Long>{
	@Query ("SELECT r FROM Reglement r where r.facture=:facture")
	public List<Reglement> retrieveReglementByFacture(@Param ("facture") Facture facture) ;
	@Query ("SELECT r FROM Reglement r where r.dateReglement between :dateD and :dateF ")
	public List<Reglement> getChiffreAffaireEntreDeuxDate(@Param ("dateD") Date dateD,@Param ("dateF") Date dateF) ;
}
