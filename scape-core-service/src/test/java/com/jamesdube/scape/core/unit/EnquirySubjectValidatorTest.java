package com.jamesdube.scape.core.unit;

import com.jamesdube.scape.core.data.request.EnquirySubject;
import com.jamesdube.scape.core.services.implementation.EnquirySubjectValidator;
import org.junit.Test;

import static com.jamesdube.scape.utils.enums.SubjectGrade.D;
import static org.junit.Assert.*;

public class EnquirySubjectValidatorTest {

	@Test
	public void itValidatesAnEnquirySubject(){

		EnquirySubjectValidator validator = new EnquirySubjectValidator();

		EnquirySubject enquirySubject = new EnquirySubject();
		enquirySubject.setSubjectCode("A-BTR");

		EnquirySubject enquirySubjectTrue = new EnquirySubject();
		enquirySubjectTrue.setSubjectCode("A-MAT");
		enquirySubjectTrue.setGrade(D);

		assertFalse(validator.isValid(enquirySubject).isValid());
		assertEquals("invalid grade for subject A-BTR",validator.isValid(enquirySubject).getErrors().get(0).getMessage());
		assertTrue(validator.isValid(enquirySubjectTrue).isValid());

	}
}
