package com.mehdimaknine.crm.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mehdimaknine.crm.models.Citta;
import com.mehdimaknine.crm.models.Provincia;


public interface CittaRepository  extends JpaRepository<Citta, Long>{
	Page<Citta> findAllByProvinceAcronym(String acronym, Pageable pageable);
	public Citta findByName (String name);
	public Citta findByNameAndProvince(String name, Provincia province);
	
	

}
