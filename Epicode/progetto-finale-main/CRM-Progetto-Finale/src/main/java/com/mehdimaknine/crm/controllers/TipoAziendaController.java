package com.mehdimaknine.crm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mehdimaknine.crm.models.TipoAzienda;
import com.mehdimaknine.crm.services.TipoAziendaService;

@RestController
@RequestMapping("/tipoazienda")
public class TipoAziendaController {

	@Autowired
	TipoAziendaService service;
	
	// Visualizza tutti i tipi azienda
	
	@GetMapping("/getall")
	@PreAuthorize("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
	public Page<TipoAzienda> findAll(Pageable pageable){
		return service.findAll(pageable);
	}
	
	// Salva tipo azienda
	
	@PostMapping("/salva")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String save (@RequestBody TipoAzienda tipoAzienda) {
		service.save(tipoAzienda);
		return "Tipo azienda salvato con successo. ";
	}
	
	// Cancella tipo azienda tramite Id
	
	@PostMapping("/delete")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String delete (@RequestParam Long id) {
		return service.delete(id);
		
	}
}
