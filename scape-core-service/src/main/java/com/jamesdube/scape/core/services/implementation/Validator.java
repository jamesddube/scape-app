package com.jamesdube.scape.core.services.implementation;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Validator {

	private boolean isValid = false;

	private List<ValidationError> errors = new ArrayList<>();

	public void addError(ValidationError validationError){
		errors.add(validationError);
	}


}
