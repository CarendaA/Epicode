package com.mehdimaknine.crm.models;

import javax.persistence.Column;
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
public class Citta extends BaseEntity {
	
	@Column(nullable = false, length = 125)
	private String name;
	private boolean capital;
	@ManyToOne
	private Provincia province;

}
