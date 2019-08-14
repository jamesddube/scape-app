package com.jamesdube.scape.core.processors.implementation;


import com.jamesdube.scape.core.data.request.EnquiryRequest;
import com.jamesdube.scape.core.data.request.EnquirySubject;
import com.jamesdube.scape.core.data.response.EnquiryResponse;
import com.jamesdube.scape.core.processors.contract.EnquiryProcessor;
import com.jamesdube.scape.core.services.contract.ClassificationService;
import com.jamesdube.scape.core.services.contract.PointsService;
import com.jamesdube.scape.core.services.implementation.EnquirySubjectValidator;
import com.jamesdube.scape.core.services.implementation.Validator;
import com.jamesdube.scape.utils.api.ApiResponse;
import com.jamesdube.scape.utils.api.ApiResponseBuilder;
import com.jamesdube.scape.utils.enums.SubjectGrade;
import com.jamesdube.scape.utils.exception.SubjectNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

public class EnquiryProcessorImpl implements EnquiryProcessor {

    private PointsService pointsService;

    private ClassificationService classificationService;

    private EnquirySubjectValidator enquirySubjectValidator;

    public EnquiryProcessorImpl(PointsService pointsService, ClassificationService classificationService,
                                EnquirySubjectValidator enquirySubjectValidator) {
        this.pointsService = pointsService;
        this.classificationService = classificationService;
        this.enquirySubjectValidator = enquirySubjectValidator;
    }

    @Override
    public ResponseEntity<ApiResponse> processEnquiry(EnquiryRequest enquiryRequest) {

        EnquiryResponse enquiryResponse = new EnquiryResponse();
        ApiResponseBuilder<EnquiryResponse> apiResponseBuilder = new ApiResponseBuilder<EnquiryResponse>();

        Validator validator = enquirySubjectValidator.isValid(enquiryRequest.getSubjectList());
        if(! validator.isValid()){
            return ResponseEntity.status(422).body(apiResponseBuilder.success(false)
                    .statusCode(422)
                    .message(validator.getErrors().get(0).getMessage())
                    .build());
        }



        List<SubjectGrade> subjectGradeList = enquiryRequest.getSubjectList().stream()
                .map(EnquirySubject::getGrade).collect(Collectors.toList());

        enquiryResponse.setPoints(pointsService.calculatePoints(subjectGradeList));
        try {
            enquiryResponse.setClassification(classificationService.calculate(enquiryRequest.getSubjectList()));
        }catch (SubjectNotFoundException e){
            return ResponseEntity.status(422).body(apiResponseBuilder
                    .success(false)
                    .statusCode(422)
                    .message(e.getMessage())
                    .build());
        }

        apiResponseBuilder
                .success(true)
                .statusCode(200)
                .message("enquiry successful")
                .data("enquiryResponse",enquiryResponse)
                .build();

        return ResponseEntity.status(apiResponseBuilder.build().getStatusCode()).body(apiResponseBuilder.build());
    }
}
