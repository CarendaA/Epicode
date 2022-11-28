package com.mehdimaknine.crm.repositories;

import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mehdimaknine.crm.models.Azienda;

public interface AziendaRepository extends JpaRepository<Azienda, Long> {

	
	
	public Page<Azienda> findAllByOrderByNome(Pageable pageable);

	public Page<Azienda> findAllByOrderByCreatedAt(Pageable pageable);
	public Page<Azienda> findAllByOrderByDataUltimoContatto(Pageable pageable);
	public Page<Azienda> findAllByOrderByIndirizzoLegaleComuneProvinceAcronym(Pageable pageable);



	 	
	public Page<Azienda> findByCreatedAtBetween(Date createdAt,Date createdAt2 ,Pageable pageable);
	public Page<Azienda> findByDataUltimoContattoBetween(Date ultimoContatto,Date ultimoContatto2 ,Pageable pageable);
	public Page<Azienda> findByNomeContains(String nome,Pageable pageable);
	
}

	


