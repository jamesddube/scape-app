package com.jamesdube.scape.core.services.contract;


import com.jamesdube.scape.core.data.request.EnquirySubject;
import com.jamesdube.scape.utils.enums.Classification;

import java.util.List;

public interface ClassificationService {

    public Classification calculate(List<EnquirySubject> enquirySubjects);
}
