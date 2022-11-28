package com.mehdimaknine.crm.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mehdimaknine.crm.models.StatoFattura;
import com.mehdimaknine.crm.repositories.StatoFatturaRepository;
import com.mehdimaknine.crm.services.StatoFatturaService;

@Service
public class StatoFatturaServiceImpl implements StatoFatturaService{

	
	@Autowired
	StatoFatturaRepository statoFatturaRepository;
	@Override
	public Optional<StatoFattura> getById(Long id) {
		try {
			return statoFatturaRepository.findById(id);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public StatoFattura save(StatoFattura statoFattura) {
try {
			return statoFatturaRepository.save(statoFattura);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public StatoFattura update(StatoFattura statoFattura) {
try {
			StatoFattura s = statoFatturaRepository.getById(statoFattura.getId());
			return statoFatturaRepository.save(statoFattura);
}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String delete(Long id) {
try {
	statoFatturaRepository.delete(statoFatturaRepository.getById(id));
			return "Stato Fattura Eliminato";
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Page<StatoFattura> findByStato(String stato, Pageable pageable) {
		
		return statoFatturaRepository.findByStato(stato, pageable);
	}

	@Override
	public Page<StatoFattura> findAll(Pageable pageable) {
		try {
			return statoFatturaRepository.findAll(pageable);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

}
