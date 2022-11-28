package com.mehdimaknine.crm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mehdimaknine.crm.models.StatoFattura;

public interface StatoFatturaRepository extends JpaRepository<StatoFattura, Long>{

	Page<StatoFattura> findByStato(String stato, Pageable pageable);
	
	
	
}
