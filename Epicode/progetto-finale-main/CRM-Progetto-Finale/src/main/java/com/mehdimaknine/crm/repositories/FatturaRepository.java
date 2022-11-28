package com.mehdimaknine.crm.repositories;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mehdimaknine.crm.models.Azienda;
import com.mehdimaknine.crm.models.Fattura;
import com.mehdimaknine.crm.models.StatoFattura;

public interface FatturaRepository extends JpaRepository<Fattura, Long>{

	public Page<Fattura> findByAzienda(Azienda azienda,Pageable pageable);
	public Page<Fattura> findByStatoFattura(StatoFattura statoFattura,Pageable pageable);
	public Page<Fattura> findByDataBetween(Date data, Date data2 ,Pageable pageable);
	@Query("SELECT f FROM Fattura f WHERE year(f.data) = :year"  )
	public Page<Fattura> findByDataYear(Integer year,Pageable pageable);
	public Page<Fattura> findByImportoBetween(BigDecimal importo,BigDecimal secondoImporto,Pageable pageable);

	
	@Query("SELECT f.azienda.id,SUM(f.importo) AS total FROM Fattura f WHERE YEAR(f.data) = :year GROUP BY f.azienda.id,f.id ORDER BY f.azienda.id")
	public Page<Fattura> findAllFatturatoByYear(int year, Pageable pageable);
	
	
}
