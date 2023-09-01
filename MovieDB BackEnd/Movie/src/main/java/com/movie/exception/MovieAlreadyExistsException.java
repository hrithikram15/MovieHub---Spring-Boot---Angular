package com.movie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT,reason="Movie Already Exists Exception ..")

public class MovieAlreadyExistsException  extends Exception{

}
