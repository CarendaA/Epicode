package com.mehdimaknine.crm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mehdimaknine.crm.models.Indirizzo;

public interface IndirizzoRepository extends JpaRepository<Indirizzo, Long>{

	
	public Page<Indirizzo> findAll(Pageable pageable);
	
	
}
