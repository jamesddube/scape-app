package com.jamesdube.scape.core.services.implementation;

import com.jamesdube.scape.core.data.Degree;
import com.jamesdube.scape.core.data.request.EnquiryRequest;
import com.jamesdube.scape.core.data.request.EnquirySubject;
import com.jamesdube.scape.core.data.response.EnquiryResponse;
import com.jamesdube.scape.core.services.contract.ClassificationService;
import com.jamesdube.scape.core.services.contract.CoreService;
import com.jamesdube.scape.core.services.contract.MatcherService;
import com.jamesdube.scape.core.services.contract.PointsService;
import com.jamesdube.scape.utils.enums.Classification;
import com.jamesdube.scape.utils.enums.SubjectGrade;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CoreServiceImpl implements CoreService {

    private PointsService pointsService;

    private ClassificationService classificationService;

    private MatcherService matcherService;

    public CoreServiceImpl(PointsService pointsService, ClassificationService classificationService,
                           MatcherService matcherService) {
        this.pointsService = pointsService;
        this.classificationService = classificationService;
        this.matcherService = matcherService;
    }

    @Override
    public EnquiryResponse process(EnquiryRequest enquiryRequest) {

        EnquiryResponse enquiryResponse = new EnquiryResponse();

        List<SubjectGrade> subjectGradeList = enquiryRequest.getSubjectList().stream()
                .map(EnquirySubject::getGrade).collect(Collectors.toList());
        int points = pointsService.calculatePoints(subjectGradeList);

        Classification classification = classificationService.calculate(enquiryRequest.getSubjectList());

        Collection<Degree> degrees = matcherService.match(points, classification);

        enquiryResponse.setPoints(points);
        enquiryResponse.setClassification(classification);
        enquiryResponse.setDegrees(degrees);

        return enquiryResponse;
    }
}
