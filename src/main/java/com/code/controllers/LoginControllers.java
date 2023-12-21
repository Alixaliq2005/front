package com.code.controllers;


import com.code.dto.request.login.LoginRequest;
import com.code.dto.response.login.LoginResponse;
import com.code.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class LoginControllers {

	private final LoginService loginService;

	// Endpoint for handling user login requests.
// Processes the login request based on the provided `loginData` parameter and returns the result in the ResponseEntity format.
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> loginHandler(@RequestBody LoginRequest loginData) {
		// Returns the result of the login operation performed in the LoginService using ResponseEntity.ok.
		return ResponseEntity.ok(loginService.logInAccount(loginData));
	}

}
