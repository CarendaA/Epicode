package com.mehdimaknine.crm.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mehdimaknine.crm.models.StatoFattura;

public interface StatoFatturaService {

	public Optional<StatoFattura> getById(Long id);
	public StatoFattura save (StatoFattura statoFattura);
	public StatoFattura update(StatoFattura statoFattura);
	public String delete(Long id);
	public Page<StatoFattura> findByStato(String stato, Pageable pageable);
	public Page<StatoFattura> findAll(Pageable pageable);
}
