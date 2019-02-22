package com.stackroute.userservice.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.service.SecurityTokenGenerator;
import com.stackroute.userservice.service.UserService;

@RestController
@RequestMapping("/api/v1/userservice")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityTokenGenerator tokenGenerator;

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user) throws Exception{
		try {
			userService.saveUser(user);
			return new ResponseEntity<String>("{\"message\":\"User registered successfully\"}", HttpStatus.CREATED);
		} catch (UserAlreadyExistsException e) {
			throw new UserAlreadyExistsException();
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User loginDetail) throws Exception{
		try {
			if (null == loginDetail.getEmail() || null == loginDetail.getPassword()) {
				throw new Exception("User Id or Password canot be empty.");
			}
			User user = userService.findByEmailAndPassword(loginDetail.getEmail(), loginDetail.getPassword());
			Map<String, String> map = tokenGenerator.generateToken(user);
			return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
		} catch (Exception e) {
			throw new UserNotFoundException();
		}
	}
}
