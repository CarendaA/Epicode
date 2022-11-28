package com.mehdimaknine.crm.models.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UtentePojo {

	
	private Long id;
	private String username;
	private String nomeCompleto;
	private String email;
	private String password;
	
}
