package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Produit;

public interface ProduitRepository extends CrudRepository<Produit, Long>{
	@Query("SELECT p FROM Produit p WHERE p.dateCreation BETWEEN '2022-01-01' AND '2022-01-31'")
	List<Produit> retrieveAllProduitsByCreation();
}