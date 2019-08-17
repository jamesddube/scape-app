package com.jamesdube.scape.core.services.contract;


import com.jamesdube.scape.core.data.request.EnquirySubject;
import com.jamesdube.scape.utils.enums.SubjectGrade;

import java.util.List;

public interface PointsService {

    public int calculatePoints(List<SubjectGrade> subjectGrades);

    public int calculatePointsFromSubjectGrades(List<EnquirySubject> subjectGrades);
}
