package com.mehdimaknine.crm.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mehdimaknine.crm.models.Utente;





public interface UtenteRepository extends JpaRepository<Utente, Long> {
	
	
	public Optional<Utente> findById(Long id);
	
	
	public Optional<Utente> findByUsername(String username);
	public List<Utente> findByNomeCompleto(String nomeCompleto);
	public List<Utente> findByEmail(String email);
	public List<Utente> findByPassword(String password);

	
	
	public List<Utente> findAll();
	
	
	
	
}
