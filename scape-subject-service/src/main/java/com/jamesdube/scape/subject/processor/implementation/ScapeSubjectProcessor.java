package com.jamesdube.scape.subject.processor.implementation;


import com.jamesdube.scape.subject.data.Subject;
import com.jamesdube.scape.subject.data.SubjectWrapper;
import com.jamesdube.scape.subject.data.domain.SubjectSpecification;
import com.jamesdube.scape.subject.processor.SubjectProcessor;
import com.jamesdube.scape.subject.services.RepositoryService;
import com.jamesdube.scape.utils.api.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.jamesdube.scape.utils.api.ApiResponseBuilder.newApiResponseBuilder;

public class ScapeSubjectProcessor implements SubjectProcessor {

    private RepositoryService repositoryService;

    public ScapeSubjectProcessor(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @Override
    public ResponseEntity<ApiResponse<List<Subject>>> search(SubjectWrapper subjectWrapper) {

        List<Subject> subjects = repositoryService.findAll(SubjectSpecification.filterByWrapper(subjectWrapper));

        ResponseEntity<ApiResponse<List<Subject>>> response = ResponseEntity.status(200).body(newApiResponseBuilder()

                .message("subjects listing")
                .success(true)
                .data("subjects",subjects)
                .statusCode(200)
                .build());

        return response;
    }
}
