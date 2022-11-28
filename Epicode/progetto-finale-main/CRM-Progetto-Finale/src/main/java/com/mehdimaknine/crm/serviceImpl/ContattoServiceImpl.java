package com.mehdimaknine.crm.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mehdimaknine.crm.models.Contatto;
import com.mehdimaknine.crm.repositories.ContattoRepository;
import com.mehdimaknine.crm.services.ContattoService;

@Service
public class ContattoServiceImpl implements ContattoService {

	
	@Autowired
	ContattoRepository contattoRepository;
	
	@Override
	public Contatto save(Contatto contatto) {
		try {
			return contattoRepository.save(contatto);
		}catch (Exception e ) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Contatto update(Contatto contatto) {
		try {
		Contatto c = contattoRepository.findById(contatto.getId()).get();
		return save(contatto);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String delete(Long id) {
		try {
			contattoRepository.delete(contattoRepository.findById(id).get());
			return "Contatto eliminato con successo ";
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Optional<Contatto> getById(long id) {
		
		return contattoRepository.findById(id);
	}

}
