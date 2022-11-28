package com.mehdimaknine.crm.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mehdimaknine.crm.models.Citta;
import com.mehdimaknine.crm.models.Provincia;
import com.mehdimaknine.crm.repositories.CittaRepository;
import com.mehdimaknine.crm.repositories.ProvinciaRepository;
import com.mehdimaknine.crm.services.CittaService;

@Service
public class CittaServiceImpl implements CittaService {

	@Autowired
	CittaRepository cittaRepository;
	@Autowired
	ProvinciaRepository provinces;
	@Override
	@Transactional
	public Citta add(Citta citta) {
		try {
			Provincia province;
			Optional<Provincia> p = provinces.findByAcronym(citta.getProvince().getAcronym());
			
			if (p.isEmpty()) {
				province = provinces.save(citta.getProvince());
			}else 
				province = p.get();
			citta.setProvince(province);
			return cittaRepository.save(citta);
		
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	
}
