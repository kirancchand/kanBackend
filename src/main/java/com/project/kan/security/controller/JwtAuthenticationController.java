package com.project.kan.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.kan.security.config.JwtTokenUtil;
import com.project.kan.security.vo.JwtRequest;
import com.project.kan.security.vo.JwtResponse;
import com.project.kan.security.service.JwtUserDetailsService;
import com.project.kan.security.vo.Users;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
	
	
@Autowired
private AuthenticationManager authenticationManager;
@Autowired
private JwtTokenUtil jwtTokenUtil;
@Autowired
private JwtUserDetailsService userDetailsService;

@RequestMapping(value = "/login", method = RequestMethod.POST)
public ResponseEntity<?> createAuthenticationToken(@RequestBody Users authenticationRequest) throws Exception {

	authenticate(authenticationRequest.getEmail_id(), authenticationRequest.getPassword());
//	final UserDetails userDetails = userDetailsService.getUserDetails(authenticationRequest.getUsername(),authenticationRequest.getPassword());
	final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail_id());
	
	final String token = jwtTokenUtil.generateToken(userDetails);
	
	return ResponseEntity.ok(new JwtResponse(token));
}

@RequestMapping(value = "/register", method = RequestMethod.POST)
public ResponseEntity<?> registerUser(@RequestBody Users users) throws Exception {
	return ResponseEntity.ok(userDetailsService.registerUser(users));
}

private void authenticate(String username, String password) throws Exception {
	try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	} catch (DisabledException e) {
		throw new Exception("USER_DISABLED", e);
	} catch (BadCredentialsException e) {
		throw new Exception("INVALID_CREDENTIALS", e);
	}
}




}
