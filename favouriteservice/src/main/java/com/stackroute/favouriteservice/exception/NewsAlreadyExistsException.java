package com.stackroute.favouriteservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT, reason="News Already Exist")
@SuppressWarnings("serial")
public class NewsAlreadyExistsException extends Exception {
}
