package com.mehdimaknine.crm.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="auth_roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private RoleType roletype;
	
	public Role(RoleType roletype) {
		this.roletype = roletype;
	}

	public Role() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoleType getRoletype() {
		return roletype;
	}

	public void setRoletype(RoleType roletype) {
		this.roletype = roletype;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roletype=" + roletype + "]";
	}


	
	
}
