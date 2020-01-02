package com.github.viniciusfcf.validation;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;

@ApplicationScoped
public class ValidationService {

	public void fazAlgo(@Valid DTOExemplo dto) {
		//fazendo algo...
	}
}
