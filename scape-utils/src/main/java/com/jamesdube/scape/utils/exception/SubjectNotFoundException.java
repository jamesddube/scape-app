package com.jamesdube.scape.utils.exception;

public class SubjectNotFoundException extends ScapeException{

	private String subjectCode;

	public SubjectNotFoundException(String subjectCode) {
		super("could not find subject using the subject-code " +subjectCode);
		this.subjectCode = subjectCode;
	}

	public String getSubjectCode() {
		return subjectCode;
	}
}
