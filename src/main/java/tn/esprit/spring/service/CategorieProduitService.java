package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.CategorieProduit;
import tn.esprit.spring.repository.CategorieProduitRepository;
@Service
public class CategorieProduitService implements ICategorieProduitService{
	@Autowired
	CategorieProduitRepository categorieProduitRepository;

	@Override
	public List<CategorieProduit> retrieveAllCategorieProduits() {
		// TODO Auto-generated method stub
		return (List<CategorieProduit>) categorieProduitRepository.findAll();
	}

	@Override
	public CategorieProduit addCategorieProduit(CategorieProduit cp) {
		// TODO Auto-generated method stub
		return categorieProduitRepository.save(cp);
	}

	@Override
	public CategorieProduit updateCategorieProduit(CategorieProduit cp) {
		// TODO Auto-generated method stub
		return categorieProduitRepository.save(cp);
	}

	@Override
	public CategorieProduit retrieveCategorieProduit(Long id) {
		// TODO Auto-generated method stub
		return categorieProduitRepository.findById(id).orElse(null);
	}

	@Override
	public void removeCategorieProduit(Long id) {
		categorieProduitRepository.deleteById(id);
	}

}
