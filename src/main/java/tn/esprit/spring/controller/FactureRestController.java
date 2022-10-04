package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.service.IFactureService;

@RestController
@RequestMapping("/facture")
public class FactureRestController {
	@Autowired
	IFactureService factureService;

	// http://localhost:8089/SpringMVC/facture/retrieve-all-factures
	@GetMapping("/retrieve-all-factures")
	@ResponseBody
	public List<Facture> getfactures() {
		List<Facture> listfactures = factureService.retrieveAllFactures();
		return listfactures;
	}

	// http://localhost:8089/SpringMVC/facture/retrieve-facture/8
	@GetMapping("/retrieve-facture/{facture-id}")
	@ResponseBody
	public Facture retrievefacture(@PathVariable(" facture-id") Long factureId) {
		return factureService.retrieveFacture(factureId);
	}

	// http://localhost:8089/SpringMVC/facture/remove-facture/{facture-id}
	@DeleteMapping("/remove-facture/{facture-id}")
	@ResponseBody
	public void cancelFacture(@PathVariable(" facture-id") Long factureId) {
	factureService.cancelFacture(factureId);
	}

}
