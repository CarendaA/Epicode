package com.mehdimaknine.crm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mehdimaknine.crm.models.Provincia;


public interface ProvinciaRepository extends JpaRepository<Provincia,Long>{
	Optional<Provincia> findByAcronym(String acronym);
}
