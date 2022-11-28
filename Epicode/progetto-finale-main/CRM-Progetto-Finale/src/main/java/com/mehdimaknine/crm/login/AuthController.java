package com.mehdimaknine.crm.login;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mehdimaknine.crm.login.security.JwtUtils;
import com.mehdimaknine.crm.login.security.services.UserDetailsImpl;
import com.mehdimaknine.crm.repositories.AziendaRepository;


@RestController
@RequestMapping
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	AziendaRepository userRepository;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
		
		// Usa l'AuthenticationManager per autenticare i parametri della request
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		// Ottiene i privilegi dell'utente
		authentication.getAuthorities();
		
		// Ottiene il SecurityContext
		SecurityContextHolder.getContext().setAuthentication(authentication);
		// Genera il token
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		// Ottiene i dati dell'utente 
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		
		// Ottiene i ruoli dell'utente
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());
		
		// Restituisce la response con status 200, token e dati dell'utente
		return ResponseEntity.ok(new LoginResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles, userDetails.getExpirationTime()));
	}
	
	
	 
	
}
