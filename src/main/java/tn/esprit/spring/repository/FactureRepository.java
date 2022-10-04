package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Fournisseur;

public interface FactureRepository extends CrudRepository<Facture, Long>{
	@Query ("SELECT f FROM Facture f where f.fournisseur=:fournisseur and f.archivee=false")
	public List<Facture> getFacturesByFournisseur(@Param("fournisseur" ) Fournisseur fournisseur) ;
}
