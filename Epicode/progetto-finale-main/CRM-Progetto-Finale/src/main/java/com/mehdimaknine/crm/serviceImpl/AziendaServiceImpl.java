package com.mehdimaknine.crm.serviceImpl;

import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mehdimaknine.crm.models.Azienda;
import com.mehdimaknine.crm.repositories.AziendaRepository;
import com.mehdimaknine.crm.repositories.FatturaRepository;
import com.mehdimaknine.crm.services.AziendaService;

@Service
public class AziendaServiceImpl implements AziendaService{

	
	@Autowired
	AziendaRepository aziendaRepository;
	@Autowired
	FatturaRepository fatturaRepository;
	
	
	@Override
	public Page<Azienda> findAllByOrderByNome(Pageable pageable) {
try {
			return aziendaRepository.findAllByOrderByNome(pageable);
		}catch ( Exception e) {
			throw new RuntimeException(e);
		}
	}

 	
 


	@Override
	public Page<Azienda> findAllByOrderByCreatedAt(Pageable pageable) {
		try {
			return aziendaRepository.findAllByOrderByCreatedAt(pageable);
		}catch ( Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	@Override
	public Page<Azienda> findAllByOrderByDataUltimoContatto(Pageable pageable) {
try {
			return aziendaRepository.findAllByOrderByDataUltimoContatto(pageable);
		}catch ( Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	
	@Override
	public Page<Azienda> findByCreatedAtBetween(Date createdAt,Date createdAt2, Pageable pageable) {
try {
			return aziendaRepository.findByCreatedAtBetween(createdAt,createdAt2, pageable);
		}catch ( Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Page<Azienda> findByDataUltimoContatto(Date dataUltimoContatto,Date dataUltimoContatto2, Pageable pageable) {
try {
			return aziendaRepository.findByDataUltimoContattoBetween(dataUltimoContatto,dataUltimoContatto2, pageable);
		}catch ( Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public Page<Azienda> findAllByOrderByAcronym(Pageable pageable) {
		try {
			return aziendaRepository.findAllByOrderByIndirizzoLegaleComuneProvinceAcronym(pageable);
		}catch(Exception e) {
			throw new RuntimeException(e);		}
		
	}

	@Override
	public Page<Azienda> findByNomeContains(String nome, Pageable pageable) {
try {
	return aziendaRepository.findByNomeContains(nome, pageable);
			
		}catch ( Exception e) {
			throw new RuntimeException(e);
		}
	}


	
	@Override
	public Optional<Azienda> getById(Long id) {
		return aziendaRepository.findById(id);
	}

	@Override
	public Azienda save(Azienda azienda) {
try {
			return aziendaRepository.save(azienda);
		}catch ( Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Azienda update( Azienda azienda) {
try {
			Azienda a = aziendaRepository.findById(azienda.getId()).get();
			return aziendaRepository.save(a);
		}catch ( Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String delete(Long id) {
try {
			aziendaRepository.delete(aziendaRepository.findById(id).get());
			return "Azienda eliminata con successo ";
		}catch ( Exception e) {
			throw new RuntimeException(e);
		}
	}



}
