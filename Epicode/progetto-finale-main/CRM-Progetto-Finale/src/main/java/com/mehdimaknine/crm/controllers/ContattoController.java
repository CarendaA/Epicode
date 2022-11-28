package com.mehdimaknine.crm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mehdimaknine.crm.models.Contatto;
import com.mehdimaknine.crm.services.ContattoService;


@RestController
@RequestMapping("/contatto")
public class ContattoController {
	
	@Autowired
	ContattoService service;

	
	// Salva contatto
	
	@PostMapping("/salva")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String save (@RequestBody Contatto contatto) {
		service.save(contatto);
		return "Contatto salvato con successo. ";
	}
	
	// Modifica contatto
	
	@PostMapping("/modifica")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String modifica (@RequestBody Contatto contatto) {
		service.update(contatto);
		return "Contatto aggiornato con successo. ";
	}
	
	
	// Cancella contatto tramite ID
	
	@PostMapping("/delete")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String delete (@RequestParam Long id) {
		return service.delete(id);
		
	}
}
