package com.github.viniciusfcf.springweb;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

// @RestControllerAdvice
@Provider
public class ExceptionHandlingController  implements ExceptionMapper<IllegalArgumentException>{

	@Override
	public Response toResponse(IllegalArgumentException exception) {
		return Response.status(Status.BAD_GATEWAY).entity("exemplo de mensagem").build();
	}

  // @ResponseStatus(value=HttpStatus.BAD_GATEWAY,
  //                 reason="Data integrity violation")
  
  // @ExceptionHandler({IllegalArgumentException.class})
  // public String databaseError() {
  //   return "exemplo de mensagem";
  // }

}