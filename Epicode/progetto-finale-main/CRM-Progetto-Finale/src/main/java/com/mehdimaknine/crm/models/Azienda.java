package com.mehdimaknine.crm.models;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(callSuper=true)
@Entity
public class Azienda extends BaseEntity {
	
	
	
	private String nome;
	private String ragioneSociale;
	private long partitaIva;
	private String email;
	private Date dataUltimoContatto;
	private String pec;
	private long telefono;
	@ManyToOne(cascade = CascadeType.ALL)
	private Contatto contatto;
	@ManyToOne(cascade = CascadeType.ALL)
	private TipoAzienda tipoAzienda;
	@OneToOne(cascade = CascadeType.ALL)
	private Indirizzo indirizzoLegale;
	@OneToOne(cascade = CascadeType.ALL)
	@Nullable
	private Indirizzo indirizzoOperativo;
	
	
	
	
	

}
