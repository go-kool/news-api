package com.stackroute.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.UNAUTHORIZED, reason="Email and Password mismatch")
@SuppressWarnings("serial")
public class UserNotFoundException extends Exception {

}
