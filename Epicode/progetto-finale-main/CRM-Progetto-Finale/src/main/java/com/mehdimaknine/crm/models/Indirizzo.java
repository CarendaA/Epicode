package com.mehdimaknine.crm.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Indirizzo extends BaseEntity{
	
	private String via;
	private String civico;
	private String localita;
	private int cap;
	@ManyToOne
	private Citta comune;


}
