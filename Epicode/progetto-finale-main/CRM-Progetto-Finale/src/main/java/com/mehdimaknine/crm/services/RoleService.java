package com.mehdimaknine.crm.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mehdimaknine.crm.models.Role;
import com.mehdimaknine.crm.repositories.RoleRepository;


@Service
public class RoleService {
	
	@Autowired
	RoleRepository roleRepository;
	
	public Optional<Role> findById(Long id){
		return roleRepository.findById(id);
		
	}
	
	public List<Role> getAll(Integer page, Integer size, String sort){
		Pageable pageable = PageRequest.of(page, size,Sort.by(sort));
		Page<Role> pagedResult = roleRepository.findAll(pageable);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		}else {
			return new ArrayList<Role>();
		}
	}
	
	public void save(Role role) {
		roleRepository.save(role);
	}
	

}
