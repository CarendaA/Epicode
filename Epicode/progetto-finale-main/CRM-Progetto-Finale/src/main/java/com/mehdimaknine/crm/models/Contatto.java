package com.mehdimaknine.crm.models;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=true)
@Entity
public class Contatto extends BaseEntity {
	
	private String email;
	private String nome;
	private String cognome;
	private long telefono;
	

}
