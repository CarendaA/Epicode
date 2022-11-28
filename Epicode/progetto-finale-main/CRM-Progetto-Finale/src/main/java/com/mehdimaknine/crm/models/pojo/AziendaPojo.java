package com.mehdimaknine.crm.models.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AziendaPojo   {
	
	private long id;
	private String nome;
	private String ragioneSociale;
	private long partitaIva;
	private String email;
	private Date dataUltimoContatto;
	private String pec;
	private long telefono;
	private long contatto;
	private long tipo;
	private long indirizzo;
	private long indirizzoOperativo;

}
