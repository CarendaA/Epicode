package com.mehdimaknine.crm.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mehdimaknine.crm.login.security.JwtUtils;
import com.mehdimaknine.crm.models.Azienda;
import com.mehdimaknine.crm.models.pojo.AziendaPojo;
import com.mehdimaknine.crm.serviceImpl.AziendaServiceImpl;
import com.mehdimaknine.crm.serviceImpl.ContattoServiceImpl;
import com.mehdimaknine.crm.serviceImpl.IndirizzoServiceImpl;
import com.mehdimaknine.crm.serviceImpl.TipoAziendaServiceImpl;

@RestController
@RequestMapping("/azienda")
public class AziendaController {

	@Autowired
	AziendaServiceImpl service;
	@Autowired
	ContattoServiceImpl contattoService;
	@Autowired
	IndirizzoServiceImpl indirizzoService;
	@Autowired
	TipoAziendaServiceImpl tipoService;
	@Autowired
	JwtUtils jwtUtils;
	
	
	// Ricerca tutte le aziende ordinate per nome
	
	@GetMapping("/totaleaziendepernome")
	@PreAuthorize("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
	public Page<Azienda> findAllByOrderByNome(@RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size,@RequestParam(defaultValue = "asc") String dir, @RequestParam(defaultValue = "id") String sort){
	
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(dir) , sort);
		return service.findAllByOrderByNome(pageable);
	}
	
	// Ricerca tutte le aziende ordinate per data di creazione
	
	@GetMapping("/totaleaziendepercreazione")
	@PreAuthorize("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
	public Page<Azienda> findAllByOrderByCreatedAt(@RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size,@RequestParam(defaultValue = "asc") String dir, @RequestParam(defaultValue = "id") String sort){

		Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(dir) , sort);
		return service.findAllByOrderByCreatedAt(pageable);
	}
	
	// Ricerca tutte le aziende ordinate per data ultimo contatto 

	@GetMapping("/totaleaziendeperdataultimocontatto")
	@PreAuthorize("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
	public Page<Azienda> findAllByOrderByDataUltimoContatto(@RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size,@RequestParam(defaultValue = "asc") String dir, @RequestParam(defaultValue = "id") String sort){

		Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(dir) , sort);
		return service.findAllByOrderByDataUltimoContatto(pageable);
	}
	
	// Ricerca tutte le aziende ordinate per acronimo provincia
	
	@GetMapping("/totaleaziendeperacronimo")
	@PreAuthorize("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
	public Page<Azienda> findByOrderByAcronym(@RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size,@RequestParam(defaultValue = "asc") String dir, @RequestParam(defaultValue = "id") String sort){
		
		
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(dir) , sort);
		return service.findAllByOrderByAcronym(pageable);
	}

	// Ricerca  le aziende tramite una data di creazione
	
	
	@PostMapping("/aziendepercreazione")
	@PreAuthorize("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
	public Page<Azienda> findByCreatedAtBetween(@RequestParam String createdAt, @RequestParam String createdAt2,@RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size,@RequestParam(defaultValue = "asc") String dir, @RequestParam(defaultValue = "id") String sort){
		try {
			Date data1 = new SimpleDateFormat("yyyy-MM-dd").parse(createdAt);
			Date data2 = new SimpleDateFormat("yyyy-MM-dd").parse(createdAt2);
			Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(dir) , sort);
			return service.findByCreatedAtBetween(data1, data2, pageable);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	// Ricerca le aziende  tramite una data di ultimo contatto

	
	@PostMapping("/aziendeperultimocontatto")
	@PreAuthorize("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
	public Page<Azienda> findByDataUltimoContatto(@RequestParam String ultimoContatto,@RequestParam String ultimoContatto2,@RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size,@RequestParam(defaultValue = "asc") String dir, @RequestParam(defaultValue = "id") String sort){
		try {
			Date data1 = new SimpleDateFormat("yyyy-MM-dd").parse(ultimoContatto);
			Date data2 = new SimpleDateFormat("yyyy-MM-dd").parse(ultimoContatto2);
			
			Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(dir) , sort);
			return service.findByDataUltimoContatto(data1, data2,pageable);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	// Ricerca le aziende tramite una parte del nome
	

	@PostMapping("/aziendeperpartedinome/{nome}")
	@PreAuthorize("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
	public Page<Azienda> findByNomeContains(@PathVariable String nome,@RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size,@RequestParam(defaultValue = "asc") String dir, @RequestParam(defaultValue = "id") String sort){
		
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(dir) , sort);
		return service.findByNomeContains(nome,pageable);
	}
	
	

	
	// Salva un'azienda
	
	@PostMapping("/salva")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String save ( @RequestBody AziendaPojo aziendaPojo) {
		
	
	new Azienda();
	Azienda a =	 Azienda.builder().
			nome(aziendaPojo.getNome()).
			ragioneSociale(aziendaPojo.getRagioneSociale()).
			partitaIva(aziendaPojo.getPartitaIva()).
			email(aziendaPojo.getEmail()).
			dataUltimoContatto(aziendaPojo.getDataUltimoContatto()).
			pec(aziendaPojo.getPec()).
			telefono(aziendaPojo.getTelefono()).
			contatto(contattoService.getById(aziendaPojo.getContatto()).get()).
			indirizzoLegale(indirizzoService.getById(aziendaPojo.getIndirizzo()).get()).
			indirizzoOperativo(indirizzoService.getById(aziendaPojo.getIndirizzoOperativo()).get()).
			tipoAzienda(tipoService.getById(aziendaPojo.getTipo()).get())
		
		.build();
	
	
		service.save(a);
		return "Azienda salvata con successo. ";
	}
	
	
	
	// Modifica azienda
	
	
	@PostMapping("/modifica")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String modifica (@RequestBody AziendaPojo aziendaPojo) {
		new Azienda();
		Azienda azienda = Azienda.builder().
				nome(aziendaPojo.getNome()).
				ragioneSociale(aziendaPojo.getRagioneSociale()).
				partitaIva(aziendaPojo.getPartitaIva()).
				email(aziendaPojo.getEmail()).
				dataUltimoContatto(aziendaPojo.getDataUltimoContatto()).
				pec(aziendaPojo.getPec()).
				telefono(aziendaPojo.getTelefono()).
				contatto(contattoService.getById(aziendaPojo.getContatto()).get()).
				indirizzoLegale(indirizzoService.getById(aziendaPojo.getIndirizzo()).get()).
				indirizzoOperativo(indirizzoService.getById(aziendaPojo.getIndirizzoOperativo()).get()).
				tipoAzienda(tipoService.getById(aziendaPojo.getTipo()).get())
				
		.build();
		azienda.setId(aziendaPojo.getId());
		service.update(azienda);
		return "Azienda aggiornata con successo. ";
	}
	
	
	// Cancella azienda tramite Id
	
	
	@PostMapping("/delete")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String delete (@RequestParam Long id) {
		return service.delete(id);
		
	}


}
