package com.jamesdube.scape.core.services.contract;

import com.jamesdube.scape.core.services.implementation.Validator;

public interface ValidationService<T> {

	Validator isValid(T t);
}
