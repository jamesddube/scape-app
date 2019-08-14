package com.jamesdube.scape.core.services.implementation;


import com.jamesdube.scape.core.data.request.EnquirySubject;
import com.jamesdube.scape.core.services.contract.ValidationService;

import java.util.List;

public class EnquirySubjectValidator implements ValidationService<EnquirySubject> {

	private Validator validator = new Validator();

	@Override
	public Validator isValid(EnquirySubject subject) {


		if(subject.getGrade() == null){
			validator.addError(new ValidationError("invalid grade for subject " + subject.getSubjectCode()));
			return validator;
		}

		validator.setValid(true);

		return validator;
	}

	public Validator isValid(List<EnquirySubject> subjectList){


		validator.setValid(subjectList.stream()
				.map(this::isValid)
				.allMatch(Validator::isValid));

		return validator;

	}
}
