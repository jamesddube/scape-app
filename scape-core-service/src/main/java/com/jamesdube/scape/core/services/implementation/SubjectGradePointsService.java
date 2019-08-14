package com.jamesdube.scape.core.services.implementation;


import com.jamesdube.scape.core.data.request.EnquirySubject;
import com.jamesdube.scape.core.services.contract.PointsService;
import com.jamesdube.scape.utils.enums.SubjectGrade;

import java.util.List;
import java.util.stream.Collectors;

public class SubjectGradePointsService implements PointsService {

    @Override
    public int calculatePointsFromSubjectGrades(List<EnquirySubject> enquirySubjects) {

        calculatePoints(enquirySubjects.stream()
                .map(EnquirySubject::getGrade)
                .collect(Collectors.toList()))
;
        return 0;
    }

    @Override
    public int calculatePoints(List<SubjectGrade> subjectGrades) {

        return subjectGrades.stream().mapToInt(SubjectGrade::getPoints).sum();
    }
}
