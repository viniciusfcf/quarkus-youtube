package com.github.viniciusfcf.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;

public class MinhaValidacaoException extends Exception {

	private static final long serialVersionUID = 1L;

	
	private final Set<? extends ConstraintViolation<?>> violations;	

	public MinhaValidacaoException(Set<? extends ConstraintViolation<?>> violations) {
		this.violations = violations;
	}

	public Set<? extends ConstraintViolation<?>> getViolations() {
		return violations;
	}

}
