package com.jamesdube.scape.core.services.implementation;

import lombok.Data;

@Data
public class ValidationError {

	private String message;

	public ValidationError(String message) {
		this.message = message;
	}
}
