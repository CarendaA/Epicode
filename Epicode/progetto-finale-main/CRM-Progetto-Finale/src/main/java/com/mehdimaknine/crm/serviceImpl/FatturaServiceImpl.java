package com.mehdimaknine.crm.serviceImpl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mehdimaknine.crm.models.Azienda;
import com.mehdimaknine.crm.models.Fattura;
import com.mehdimaknine.crm.models.StatoFattura;
import com.mehdimaknine.crm.repositories.FatturaRepository;
import com.mehdimaknine.crm.services.FatturaService;

@Service
public class FatturaServiceImpl implements FatturaService {

	@Autowired
	FatturaRepository fatturaRepository;

	
	
	
	@Override
	public Page<Fattura> getByAzienda(Azienda azienda, Pageable pageable) {
		try {
			return fatturaRepository.findByAzienda(azienda, pageable);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	

	@Override
	public Page<Fattura> getByStatoFattura(StatoFattura statoFattura, Pageable pageable) {
		try {
			return fatturaRepository.findByStatoFattura(statoFattura, pageable);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	@Override
	public Page<Fattura> getByData(Date data,Date data2, Pageable pageable) {
		try {
			return fatturaRepository.findByDataBetween(data,data2, pageable);	
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	@Override
	public Page<Fattura> getByDataYear(Integer year, Pageable pageable) {
		try {
			return fatturaRepository.findByDataYear(year, pageable);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	@Override
	public Page<Fattura> getByImportoBetween(BigDecimal importo, BigDecimal importo2, Pageable pageable) {
		try {
			return fatturaRepository.findByImportoBetween(importo, importo2, pageable);	
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	@Override
	public Optional<Fattura> getById(Long id) {
		return fatturaRepository.findById(id) ;
	}
	
	
	

	@Override
	public Page<Fattura> findAllFatturatoByYear(int year,Pageable pageable) {
		try {
			 
			return fatturaRepository.findAllFatturatoByYear(year,pageable);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	
	@Override
	public Fattura save(Fattura fattura) {
		try {		
			return fatturaRepository.save(fattura);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	@Override
	public Fattura update(Fattura fattura) {
		try {
			Fattura f = fatturaRepository.findById(fattura.getId()).get();
			 return fatturaRepository.save(fattura);
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	@Override
	public String delete(Long id) {
		try {
			 fatturaRepository.delete(fatturaRepository.getById(id));
			return "Fattura Eliminata con successo ";
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
