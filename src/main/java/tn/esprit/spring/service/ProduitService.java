package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.CategorieProduit;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.CategorieProduitRepository;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.repository.StockRepository;

@Slf4j
@Service
public class ProduitService implements IProduitService {
	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	CategorieProduitRepository categorieproduitRepository;
	@Autowired
	StockRepository stockRepository;

	@Override
	public List<Produit> retrieveAllProduits() {
		// TODO Auto-generated method stub
		List<Produit> products = (List<Produit>) produitRepository.findAll();
		if (products != null) {
			for (Produit p : products) {
				log.info("Product" + p);
			}
		}
		return products;
	}

	@Override
	public Produit addProduit(Produit p, Long idCategorieProduit, Long idStock) {
		CategorieProduit cp = categorieproduitRepository.findById(idCategorieProduit).orElse(null);
		Stock stck = stockRepository.findById(idStock).orElse(null);
		p.setCategorieproduit(cp);
		p.setStock(stck);
		produitRepository.save(p);
		return p;
	}

	@Override
	public Produit updateProduit(Produit p, Long idCategorieProduit, Long idStock) {
		CategorieProduit cp = categorieproduitRepository.findById(idCategorieProduit).orElse(null);
		Stock stck = stockRepository.findById(idStock).orElse(null);
		p.setCategorieproduit(cp);
		p.setStock(stck);
		produitRepository.save(p);
		return p;
	}

	@Override
	public Produit retrieveProduit(Long id) {
		// TODO Auto-generated method stub
		return produitRepository.findById(id).orElse(null);
	}

	@Override
	public List<Produit> retrieveAllProduitsByCreation() {
		// TODO Auto-generated method stub
		return produitRepository.retrieveAllProduitsByCreation();
	}
	@Override
	public void assignProduitToStock(Long idProduit, Long idStock) {				
		Produit p = produitRepository.findById(idProduit).orElse(null);
		Stock s = stockRepository.findById(idStock).orElse(null);
		p.setStock(s);
		stockRepository.save(s);
	}


}
