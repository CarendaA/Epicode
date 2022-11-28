package com.mehdimaknine.crm.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mehdimaknine.crm.models.TipoAzienda;

;

public interface TipoAziendaService {
	
	public Optional<TipoAzienda> getById(Long id);
	public TipoAzienda save (TipoAzienda tipoAzienda);

	public String delete(Long id);
	public Page<TipoAzienda> findAll(Pageable pageable);
	
	

}
