package com.movie.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason ="Movie doesn't exists")
public class MovieNotFoundException extends Exception{

}
