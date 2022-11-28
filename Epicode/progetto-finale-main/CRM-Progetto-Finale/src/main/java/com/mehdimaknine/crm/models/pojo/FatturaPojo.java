package com.mehdimaknine.crm.models.pojo;

import java.math.BigDecimal;
import java.util.Date;

import com.mehdimaknine.crm.models.StatoFattura;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FatturaPojo  {
	
	private long id;
	private Date data;
	private BigDecimal importo;
	private StatoFattura statoFattura;
	private int numero;
	private long idAzienda;

}
