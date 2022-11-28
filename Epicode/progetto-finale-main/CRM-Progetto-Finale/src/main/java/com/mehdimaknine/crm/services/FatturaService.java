package com.mehdimaknine.crm.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mehdimaknine.crm.models.Azienda;
import com.mehdimaknine.crm.models.Fattura;
import com.mehdimaknine.crm.models.StatoFattura;

public interface FatturaService {
	
	public Page<Fattura> getByAzienda(Azienda azienda, Pageable pageable);
	public Page<Fattura> getByStatoFattura(StatoFattura statoFattura,Pageable pageable);
	public Page<Fattura> getByData(Date data,Date data2,Pageable pageable);
	public Page<Fattura> getByDataYear(Integer year,Pageable pageable);
	public Page<Fattura> getByImportoBetween(BigDecimal importo,BigDecimal secondoImporto,Pageable pageable);
	
	public Page<Fattura> findAllFatturatoByYear(int year, Pageable pageable);
	
	
	
	public Optional<Fattura> getById(Long id);
	
	public Fattura save(Fattura fattura);
	public Fattura update (Fattura fattura);
	public String delete (Long id);
}
