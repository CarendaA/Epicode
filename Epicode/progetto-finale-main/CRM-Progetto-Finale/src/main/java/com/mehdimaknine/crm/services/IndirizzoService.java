package com.mehdimaknine.crm.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mehdimaknine.crm.models.Indirizzo;

public interface IndirizzoService {
	
	public Page<Indirizzo> findAll(Pageable pageable);
	public Optional<Indirizzo> getById(Long id);
	public Indirizzo save (Indirizzo indirizzo, String nomecomune, String prov);
	public Indirizzo update(Indirizzo indirizzo);
	public String delete(Long id);
	

}
