package com.mehdimaknine.crm.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mehdimaknine.crm.repositories.AziendaRepository;
import com.mehdimaknine.crm.repositories.CittaRepository;
import com.mehdimaknine.crm.repositories.IndirizzoRepository;
import com.mehdimaknine.crm.repositories.ProvinciaRepository;
import com.mehdimaknine.crm.repositories.StatoFatturaRepository;
import com.mehdimaknine.crm.repositories.TipoAziendaRepository;
import com.mehdimaknine.crm.repositories.UtenteRepository;
import com.mehdimaknine.crm.serviceImpl.CittaServiceImpl;

@Component
public class CrmRunner implements CommandLineRunner{

	@Autowired
	CittaRepository cittaRepository;
	@Autowired
	ProvinciaRepository provinciaRepository;
	@Autowired
	AziendaRepository aziendaRepository;
	@Autowired
	CittaServiceImpl cittaService;
	@Autowired
	UtenteRepository utenteRepository;
	@Autowired
	IndirizzoRepository indirizzoRepository;
	@Autowired
	StatoFatturaRepository statoFatturaRepository;
	@Autowired
	TipoAziendaRepository tipoAziendaRepository;
	@Override
	public void run(String... args) throws Exception {
	/*	
		String filename = "C:\\Users\\admin\\Desktop\\EpiCode\\Programmi\\CitiesLoader\\comuni.csv";
	
	Set<City> cities = CitiesLoader.load(new FileInputStream(filename));
*/
/*	for(City city: cities) {
		Provincia p = new Provincia();
		p.setAcronym(city.getProvince().getAcronym());
		p.setName(city.getProvince().getName());
		Citta c = new Citta(city.getName(),city.isCapital(), p);
		provinciaRepository.save(p);
		cittaRepository.save(c);
	} 
	*/
	
/*	cities.stream().map(c-> Citta.builder()
			.capital(c.isCapital())
			.name(c.getName())
			.province(Provincia.builder()
					.name(c.getProvince().getName())
					.acronym(c.getProvince().getAcronym()).build()).build()).forEach(c -> cittaService.add(c));*/
  
	/*	Contatto c = new Contatto("Mehdi@gmail.com", "Mehdi","Maknine", 58613354);
		Azienda b = new Azienda().builder().nome("Mehdi")
                .ragioneSociale("consulenza")
                .partitaIva(1234569)
                .email("MEHDI@GMAIL.COM")
     //           .fatturatoAnnuale(10000000)
                .dataUltimoContatto(new Date(1/4/2022))
                .pec("MEHDI@GMAIL.COM")
                .telefono(32565895)
      //          .contatto(c)
                .tipoAzienda(new TipoAzienda("SPA")).build();
     //           .indirizzoOperativo(new Indirizzo("via Mancini","55","zona industriale",022255,cittaRepository.findByName("Pesaro")))
      //          .indirizzoLegale(new Indirizzo("via zucchetti legle","66","zona centro",256155,cittaRepository.findByName("Roma"))).build();
		aziendaRepository.save(b); 
		*/
	
	


	}
}
