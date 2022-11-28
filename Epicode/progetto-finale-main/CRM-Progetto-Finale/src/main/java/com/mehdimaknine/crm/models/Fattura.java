package com.mehdimaknine.crm.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
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
public class Fattura extends BaseEntity{

	private Date data;
	private BigDecimal importo;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;
	@ManyToOne(cascade = CascadeType.ALL)
	private Azienda azienda;
	@ManyToOne(cascade = CascadeType.ALL)
	private StatoFattura statoFattura;

}
