package com.stackroute.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT, reason="User with Email already exists")
@SuppressWarnings("serial")
public class UserAlreadyExistsException extends Exception {

}
