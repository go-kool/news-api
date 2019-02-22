package com.stackroute.favouriteservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason="News Not Exist")
@SuppressWarnings("serial")
public class NewsNotFoundException extends Exception  {

}
