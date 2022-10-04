package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.service.IProduitService;
@RestController
@RequestMapping("/produit")
public class ProduitRestController {
	@Autowired
	IProduitService produitService;

	// http://localhost:8089/SpringMVC/produit/retrieve-all-produits
	@GetMapping("/retrieve-all-produits")
	@ResponseBody
	public List<Produit> getProduits() {
		List<Produit> listProduits = produitService.retrieveAllProduits();
		return listProduits;
	}
	
	// http://localhost:8089/SpringMVC/produit/retrieve-all-produits-creation
		@GetMapping("/retrieve-all-produits-creation")
		@ResponseBody
		public List<Produit> getProduitsByCreation() {
			List<Produit> listProduits = produitService.retrieveAllProduitsByCreation();
			return listProduits;
		}

	// http://localhost:8089/SpringMVC/produit/retrieve-produit/8
	@GetMapping("/retrieve-produit/{produit-id}")
	@ResponseBody
	public Produit retrieveProduit(@PathVariable(" produit-id") Long produitId) {
		return produitService.retrieveProduit(produitId);
	}

	
	// http://localhost:8089/SpringMVC/produit/modify-produit
	
}
