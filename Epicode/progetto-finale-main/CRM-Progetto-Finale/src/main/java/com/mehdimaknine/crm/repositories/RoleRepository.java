package com.mehdimaknine.crm.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mehdimaknine.crm.models.Role;
import com.mehdimaknine.crm.models.RoleType;



public interface RoleRepository extends JpaRepository<Role, Long> {
	
	public Optional<Role> findById(Long id);
	public List<Role> findByRoletype(RoleType roleType);

	
	public Page<Role> findAll(Pageable pageable);
}
