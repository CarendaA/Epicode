package com.mehdimaknine.crm.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mehdimaknine.crm.models.Utente;
import com.mehdimaknine.crm.models.pojo.UtentePojo;
import com.mehdimaknine.crm.repositories.UtenteRepository;
import com.mehdimaknine.crm.services.UtenteService;


@Service
public class UtenteServiceImp implements UtenteService{

	@Autowired
	UtenteRepository utenteRepository;
	
	@Autowired 
	PasswordEncoder encoder;
	
	public Optional<Utente> findById(Long id){
		return utenteRepository.findById(id);
	}
	
		public List<Utente> getAll() {
			List<Utente> pagedResult = utenteRepository.findAll();
			if (!pagedResult.isEmpty()) {
				return pagedResult;
			}else {
				return new ArrayList<Utente>();
			}
		}
		
		@Override
		@Transactional
		public void add(UtentePojo utentePojo) {
			try {
			Utente utente = new Utente();
			utente.setUsername(utentePojo.getUsername());
			utente.setNomeCompleto(utentePojo.getNomeCompleto());
			utente.setEmail(utentePojo.getEmail());
			
			utente.setPassword(encoder.encode(utentePojo.getPassword()));
			
			utenteRepository.save(utente);
			}catch (Exception e) {
				
			}
		}

		public Optional<Utente> findByName(String username) {
			
			return utenteRepository.findByUsername(username);
		}
		
		
		

		
		
		
		
	}

