package com.rating.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT,reason="User Review Already Exists Exception ..")

public class UserReviewAlreadyExistsException extends Exception {

}
