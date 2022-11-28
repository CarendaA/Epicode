package com.mehdimaknine.crm.controllers;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import com.mehdimaknine.crm.models.Azienda;
import com.mehdimaknine.crm.models.Fattura;
import com.mehdimaknine.crm.models.StatoFattura;
import com.mehdimaknine.crm.models.pojo.FatturaPojo;
import com.mehdimaknine.crm.serviceImpl.AziendaServiceImpl;
import com.mehdimaknine.crm.serviceImpl.FatturaServiceImpl;
import com.mehdimaknine.crm.serviceImpl.StatoFatturaServiceImpl;

@RestController
@RequestMapping("/fattura")
public class FatturaController {
	@Autowired
	AziendaServiceImpl aziendaService;
	@Autowired
	FatturaServiceImpl fatturaService; 
	@Autowired
	StatoFatturaServiceImpl statoService;
	
	//Metodo ricerca Fatture tramite l'id dell'azienda
	@GetMapping("/perazienda")
	@PreAuthorize("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
	public Page<Fattura> findByAzienda(@RequestParam Long id, @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size,@RequestParam(defaultValue = "asc") String dir, @RequestParam(defaultValue = "id") String sort){
		
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(dir) , sort);
		Azienda a = aziendaService.getById(id).get();
		return fatturaService.getByAzienda(a, pageable);		
	}
	//Metodo di ricerca Fatture tramite lo Stato Fattura
	@PostMapping("/perstatofattura")
	@PreAuthorize("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
	public Page<Fattura> findByStatoFattura(@RequestParam String stato, @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size,@RequestParam(defaultValue = "asc") String dir, @RequestParam(defaultValue = "id") String sort){
		
		
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(dir) , sort);
		Page<StatoFattura> p = statoService.findByStato(stato,pageable);
		if(p.isEmpty()) {
			return null;
		}
		List<StatoFattura> s = p.getContent();
		return fatturaService.getByStatoFattura(s.get(0), pageable);
	}	
		
	//Metodo di ricerca Fatture tramite due date ( data iniziale , data finale )
	@PostMapping("/perdata")
	@PreAuthorize("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
	public Page<Fattura> findByDataBetween(@RequestParam String data, String data2 , @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size,@RequestParam(defaultValue = "asc") String dir, @RequestParam(defaultValue = "id") String sort){
			
		// parse data da una stringa a un formato data
		try {
			Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(data);
			Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse(data2);
			
			Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(dir) , sort);
			return fatturaService.getByData(d1, d2, pageable);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	//Metodo di ricerca fatture per anno creazione
	@PostMapping("/peranno")
	@PreAuthorize("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
	public Page<Fattura> findByDataYear(@RequestParam Integer year , @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size,@RequestParam(defaultValue = "asc") String dir, @RequestParam(defaultValue = "id") String sort){
		
		
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(dir) , sort);
		return fatturaService.getByDataYear(year, pageable);
	}
	//Metodo di ricerca fatture tramite due importi (importo minimo , importo massimo)
	@PostMapping("/perimporto")
	@PreAuthorize("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
	public Page<Fattura> findByImportoBetween(@RequestParam BigDecimal importo,@RequestParam BigDecimal secondoImporto,@RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size,@RequestParam(defaultValue = "asc") String dir, @RequestParam(defaultValue = "id") String sort){
		
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(dir) , sort);
		return fatturaService.getByImportoBetween(importo, secondoImporto, pageable);
		
	}
	
	//Metodo di ricerca fatture per il fatturato annuale
	@PostMapping("/fatturatoannuale")
	@PreAuthorize("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
	public Page<Fattura> getFatturatoAnnualeByAzienda(@RequestParam int year,@RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size,@RequestParam(defaultValue = "asc") String dir, @RequestParam(defaultValue = "id") String sort)
	{
		try {
			Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(dir), sort);
			return fatturaService.findAllFatturatoByYear(year, pageable);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	//Salva una fattura
	@PostMapping("/salva")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String save (@RequestParam long idAzienda, @RequestBody FatturaPojo fatturaPojo) {
		
		Fattura fattura = Fattura.builder()
				.data(fatturaPojo.getData())
				.importo(fatturaPojo.getImporto())
				.azienda(aziendaService.getById(idAzienda).get())
				.numero(fatturaPojo.getNumero())
				.statoFattura(fatturaPojo.getStatoFattura())				
				.build();
				
		fatturaService.save(fattura);
		return "Fattura salvata con successo. ";
	}
	//Modifica fattura
	@PostMapping("/modifica")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String modifica (@RequestBody FatturaPojo fatturaPojo) {
		Fattura fattura = Fattura.builder()
				.data(fatturaPojo.getData())
				.importo(fatturaPojo.getImporto())
				.azienda(aziendaService.getById(fatturaPojo.getIdAzienda()).get())
				.statoFattura(fatturaPojo.getStatoFattura())	
				.numero(fatturaPojo.getNumero())
				.build();
		fattura.setId(fatturaPojo.getId());
		fatturaService.update(fattura);
		return "Fattura aggiornata con successo. ";
	}
	//Cancella fattura tramite id
	@PostMapping("/delete/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")	
	public String delete (@PathVariable Long id) {
		return fatturaService.delete(id);
		
	}

}
