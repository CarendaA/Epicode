package com.mehdimaknine.crm.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mehdimaknine.crm.models.TipoAzienda;
import com.mehdimaknine.crm.repositories.TipoAziendaRepository;
import com.mehdimaknine.crm.services.TipoAziendaService;

@Service
public class TipoAziendaServiceImpl implements TipoAziendaService{

	
	@Autowired
	TipoAziendaRepository tipoAziendaRepository;
	
	@Override
	public Optional<TipoAzienda> getById(Long id) {
		try {
			return tipoAziendaRepository.findById(id);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public TipoAzienda save(TipoAzienda tipoAzienda) {
		try {
			return tipoAziendaRepository.save(tipoAzienda);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String delete(Long id) {
		try {
			tipoAziendaRepository.delete(tipoAziendaRepository.getById(id));
			return"Tipo azienda eliminato con successo";
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Page<TipoAzienda> findAll(Pageable pageable) {
		try {
			return tipoAziendaRepository.findAll(pageable);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

}
