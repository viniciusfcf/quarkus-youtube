package com.github.viniciusfcf.validation;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MinhaValidacaoExceptionHandler implements ExceptionMapper<MinhaValidacaoException> {

	@Override
	public Response toResponse(MinhaValidacaoException exception) {
		ResultadoErroValidacao respostaErroValidacao = new ResultadoErroValidacao(exception.getViolations());
		return Response.status(Status.BAD_REQUEST).entity(respostaErroValidacao).build();
	}

	public class ResultadoErroValidacao {
		
		private String mensagem;
		
		ResultadoErroValidacao(Set<? extends ConstraintViolation<?>> violations) {
			this.mensagem = violations.stream().map(cv -> cv.getMessage()).collect(Collectors.joining(", "));
		}

		public String getMensagem() {
			return mensagem;
		}

	}
	
}