package com.mehdimaknine.crm.services;

import java.util.Optional;

import com.mehdimaknine.crm.models.Contatto;

public interface ContattoService {
	
	public Contatto save(Contatto contatto);
	public Contatto update(Contatto contatto);
	public String delete(Long id);
	public Optional<Contatto> getById(long id);

}
