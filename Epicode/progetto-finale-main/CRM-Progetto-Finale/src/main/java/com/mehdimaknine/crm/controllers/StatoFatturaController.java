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

import com.mehdimaknine.crm.models.StatoFattura;
import com.mehdimaknine.crm.services.StatoFatturaService;

@RestController
@RequestMapping("/statofattura")
public class StatoFatturaController {
	
	@Autowired
	StatoFatturaService service;  
	
	
	// Visualizza tutti gli stati fattura
	
	
	@GetMapping("/getall")
	@PreAuthorize("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
	public Page<StatoFattura> findAll(Pageable pageable){
		return service.findAll(pageable);
	}
	
	// Salva stato fattura
	
	@PostMapping("/salva")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String save (@RequestBody StatoFattura statoFattura) {
		service.save(statoFattura);
		return "Stato fattura salvato con successo. ";
	}
	
	// Modifica stato fattura
	
	@PostMapping("/modifica")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String modifica (@RequestBody StatoFattura statoFattura) {
		service.update(statoFattura);
		return "Stato fattura aggiornata con successo. ";
	}
	
	// Cancella stato fattura tramite Id
	
	@PostMapping("/delete")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String delete (@RequestParam Long id) {
		return service.delete(id);
		
	}

}
