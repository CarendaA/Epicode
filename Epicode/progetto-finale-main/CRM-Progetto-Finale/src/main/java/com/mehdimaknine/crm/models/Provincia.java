package com.mehdimaknine.crm.models;

import javax.persistence.Column;
import javax.persistence.Entity;

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
public class Provincia extends BaseEntity{
	
	@Column(nullable = false , length = 80)
	private String name;
	@Column(nullable = false, length = 2)
	private String acronym;

}
