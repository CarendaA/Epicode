package com.mehdimaknine.crm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.mehdimaknine.crm.models.Indirizzo;
import com.mehdimaknine.crm.services.IndirizzoService;

@RestController
@RequestMapping("/indirizzo")
public class IndirizzoController {
	
	@Autowired
	IndirizzoService service;  
	
	
	// Visualizza tutti gli indirizzi
	
	@GetMapping("/getall")
	@PreAuthorize("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
	public Page<Indirizzo> findAll(Pageable pageable){
		return service.findAll(pageable);
	}
	
	
	// Salva Indirizzo
	
	@PostMapping("/salva/{nomecomune}/{prov}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String save (@RequestBody Indirizzo indirizzo, @PathVariable String nomecomune, @PathVariable String prov) {
		service.save(indirizzo, nomecomune, prov);
		return "Indirizzo salvato con successo. ";
	}
	
	// Modifica indirizzo
	
	@PostMapping("/modifica")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String modifica (@RequestBody Indirizzo indirizzo) {
		service.update(indirizzo);
		return "Indirizzo aggiornato con successo. ";
	}
	
	// Cancella indirizzo tramite Id
	
	@PostMapping("/delete")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String delete (@RequestParam Long id) {
		return service.delete(id);
		
	}

}
