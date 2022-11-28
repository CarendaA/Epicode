package com.mehdimaknine.crm.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Utente {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String nomeCompleto;
	private String email;
	private String password;
	
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	Set<Role> roles = new HashSet<>();


	public Utente(String username, String nomeCompleto, String email, String password) {
		this.username = username;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.password = password;
		
	}


	public Utente() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getNomeCompleto() {
		return nomeCompleto;
	}


	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	@Override
	public String toString() {
		return "Utente [id=" + id + ", username=" + username + ", nomeCompleto=" + nomeCompleto + ", email=" + email
				+ ", password=" + password + ", roles=" + roles + "]";
	}
	
	
	
	
	
}
