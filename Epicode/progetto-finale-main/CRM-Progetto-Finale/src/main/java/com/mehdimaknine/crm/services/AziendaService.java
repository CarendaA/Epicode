package com.mehdimaknine.crm.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mehdimaknine.crm.models.Azienda;

public interface AziendaService {

	
	public Page<Azienda> findAllByOrderByNome(Pageable pageable);	public Page<Azienda> findAllByOrderByCreatedAt(Pageable pageable);
	public Page<Azienda> findAllByOrderByDataUltimoContatto(Pageable pageable);
	public Page<Azienda> findByCreatedAtBetween(Date createdAt,Date createdAt2, Pageable pageable);
	public Page<Azienda> findByDataUltimoContatto(Date dataUltimoContatto,Date dataUltimoContatto2, Pageable pageable);
	public Page<Azienda> findByNomeContains(String nome,Pageable pageable);
	public Page<Azienda> findAllByOrderByAcronym(Pageable pageable);


	
	public Optional<Azienda> getById(Long id);
	
	public Azienda save ( Azienda azienda);
	public Azienda update ( Azienda azienda );
	public String delete (Long id);

}
