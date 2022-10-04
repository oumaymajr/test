package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.SecteurActivite;
import tn.esprit.spring.service.ISecteurActiviteService;

@RestController
@RequestMapping("/secteurActivite")
public class SecteurActiviteRestController {
	@Autowired
	ISecteurActiviteService secteurActiviteService;

	// http://localhost:8089/SpringMVC/secteurActivite/retrieve-all-secteurActivites
	@GetMapping("/retrieve-all-secteurActivites")
	@ResponseBody
	public List<SecteurActivite> getSecteurActivites() {
		List<SecteurActivite> listSecteurActivites = secteurActiviteService.retrieveAllSecteurActivites();
		return listSecteurActivites;
	}

	// http://localhost:8089/SpringMVC/secteurActivite/retrieve-secteurActivite/8
	@GetMapping("/retrieve-secteurActivite/{secteurActivite-id}")
	@ResponseBody
	public SecteurActivite retrieveSecteurActivite(@PathVariable(" secteurActivite-id") Long secteurActiviteId) {
		return secteurActiviteService.retrieveSecteurActivite(secteurActiviteId);
	}

	// http://localhost:8089/SpringMVC/secteurActivite/add-secteurActivite
	@PostMapping("/add-secteurActivite")
	@ResponseBody
	public SecteurActivite addSecteurActivite(@RequestBody SecteurActivite o) {
		SecteurActivite secteurActivite = secteurActiviteService.addSecteurActivite(o);
		return secteurActivite;
	}
	// http://localhost:8089/SpringMVC/secteurActivite/remove-secteurActivite/{secteurActivite-id}
	@DeleteMapping("/remove-secteurActivite/{secteurActivite-id}")
	@ResponseBody
	public void removeSecteurActivite(@PathVariable(" secteurActivite-id") Long secteurActiviteId) {
	secteurActiviteService.removeSecteurActivite(secteurActiviteId);
	}

	// http://localhost:8089/SpringMVC/secteurActivite/modify-secteurActivite
	@PutMapping("/modify-secteurActivite")
	@ResponseBody
	public SecteurActivite modifySecteurActivite(@RequestBody SecteurActivite secteurActivite) {
	return secteurActiviteService.updateSecteurActivite(secteurActivite);
	}
}
