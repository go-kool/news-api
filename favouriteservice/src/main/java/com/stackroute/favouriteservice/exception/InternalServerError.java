package com.stackroute.favouriteservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason="Internal Server Error")
@SuppressWarnings("serial")
public class InternalServerError extends Exception  {

}
