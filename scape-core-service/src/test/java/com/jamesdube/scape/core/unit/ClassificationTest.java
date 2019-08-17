package com.jamesdube.scape.core.unit;

import com.jamesdube.scape.core.data.Subject;
import com.jamesdube.scape.core.data.request.EnquirySubject;
import com.jamesdube.scape.core.services.contract.ClassificationService;
import com.jamesdube.scape.core.services.contract.SubjectService;
import com.jamesdube.scape.core.services.implementation.SubjectsClassificationService;
import com.jamesdube.scape.utils.enums.Classification;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.jamesdube.scape.utils.enums.Classification.ARTS;
import static com.jamesdube.scape.utils.enums.Classification.SCIENCES;
import static com.jamesdube.scape.utils.enums.SubjectGrade.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClassificationTest {

    @Test
    public void itCalculatesClassification(){

        Subject maths = new Subject("A-MAT",SCIENCES);
        Subject physics = new Subject("A-PHY",SCIENCES);
        Subject chemistry = new Subject("A-CHE",SCIENCES);
        Subject history = new Subject("A-HIS",ARTS);
        Subject shona = new Subject("A-SHO",ARTS);
        Subject literature = new Subject("A-LIT",ARTS);

        SubjectService subjectService = mock(SubjectService.class);

        when(subjectService.findByCode(maths.getCode())).thenReturn(maths);
        when(subjectService.findByCode(physics.getCode())).thenReturn(physics);
        when(subjectService.findByCode(chemistry.getCode())).thenReturn(chemistry);
        when(subjectService.findByCode(history.getCode())).thenReturn(history);
        when(subjectService.findByCode(literature.getCode())).thenReturn(literature);
        when(subjectService.findByCode(shona.getCode())).thenReturn(shona);

        ClassificationService classificationService = new SubjectsClassificationService(subjectService);

        List<EnquirySubject> enquirySubjectList = new ArrayList<>();

        enquirySubjectList.add(new EnquirySubject("A-MAT",A));
        enquirySubjectList.add(new EnquirySubject("A-PHY",B));
        enquirySubjectList.add(new EnquirySubject("A-CHE",A));


        Classification sciences = classificationService.calculate(enquirySubjectList);

        assertEquals(SCIENCES,sciences);

        List<EnquirySubject> enquirySubjectListArts = new ArrayList<>();

        enquirySubjectListArts.add(new EnquirySubject("A-SHO",B));
        enquirySubjectListArts.add(new EnquirySubject("A-LIT",B));
        enquirySubjectListArts.add(new EnquirySubject("A-HIS",C));

        Classification arts = classificationService.calculate(enquirySubjectListArts);

        assertEquals(ARTS,arts);

    }
}
