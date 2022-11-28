package com.mehdimaknine.crm.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mehdimaknine.crm.models.Citta;
import com.mehdimaknine.crm.models.Indirizzo;
import com.mehdimaknine.crm.models.Provincia;
import com.mehdimaknine.crm.repositories.CittaRepository;
import com.mehdimaknine.crm.repositories.IndirizzoRepository;
import com.mehdimaknine.crm.repositories.ProvinciaRepository;
import com.mehdimaknine.crm.services.IndirizzoService;

@Service
public class IndirizzoServiceImpl implements IndirizzoService {

	
	@Autowired
	IndirizzoRepository indirizzoRepository;
	@Autowired
	CittaRepository cittaRepository;
	@Autowired
	ProvinciaRepository provinceRepository;
	
	@Override
	public Optional<Indirizzo> getById(Long id) {
		try {
			return indirizzoRepository.findById(id);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Indirizzo save(Indirizzo indirizzo, String nomecomune , String prov) {
	try {
		Provincia p = provinceRepository.findByAcronym(prov).get();
		Citta c = cittaRepository.findByNameAndProvince(nomecomune, p);
		indirizzo.setComune(c);
			return indirizzoRepository.save(indirizzo);
		}catch(Exception e) { 
			throw new RuntimeException(e);
		}
	}

	@Override
	public Indirizzo update(Indirizzo indirizzo) {
	try {
			Indirizzo i = indirizzoRepository.getById(indirizzo.getId());
			return indirizzoRepository.save(indirizzo);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String delete(Long id) {
	try {
			indirizzoRepository.delete(indirizzoRepository.getById(id));
			return "Indirizzo eliminato con successo";
			}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Page<Indirizzo> findAll(Pageable pageable) {
		try {
			return indirizzoRepository.findAll(pageable);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
