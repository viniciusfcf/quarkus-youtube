package com.github.viniciusfcf.springweb;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlingController {

  @ResponseStatus(value=HttpStatus.BAD_GATEWAY,
                  reason="Data integrity violation")
  
  @ExceptionHandler({IllegalArgumentException.class})
  public String databaseError() {
    return "exemplo de mensagem";
  }

}