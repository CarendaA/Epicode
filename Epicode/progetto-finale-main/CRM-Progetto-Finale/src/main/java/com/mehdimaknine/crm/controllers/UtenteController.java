package com.mehdimaknine.crm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehdimaknine.crm.models.pojo.UtentePojo;
import com.mehdimaknine.crm.serviceImpl.UtenteServiceImp;

@RestController
@RequestMapping("/utente")
public class UtenteController { 
	
	@Autowired
	UtenteServiceImp service;
	
	// Salva un utente
	
	@PostMapping("/salva")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void save (@RequestBody UtentePojo utente) {
		service.add(utente);
	}

}
