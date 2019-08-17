package com.jamesdube.scape.degree.services;

import com.jamesdube.scape.degree.data.Degree;
import com.jamesdube.scape.degree.data.DegreeSpecification;
import com.jamesdube.scape.degree.data.DegreeWrapper;
import com.jamesdube.scape.utils.api.ApiResponse;
import com.jamesdube.scape.utils.api.ApiResponseBuilder;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.jamesdube.scape.utils.api.ApiResponseBuilder.newApiResponseBuilder;

public class DegreeProcessorImpl implements DegreeProcessor {

    private DegreeRepository degreeRepository;

    public DegreeProcessorImpl(DegreeRepository degreeRepository) {
        this.degreeRepository = degreeRepository;
    }

    @Override
    public ResponseEntity<ApiResponse<List<Degree>>> search(DegreeWrapper subjectWrapper) {

        List<Degree> degrees = degreeRepository.findAll(DegreeSpecification.filterByWrapper(subjectWrapper));

        ApiResponseBuilder<List<Degree>> apiResponseBuilder = new ApiResponseBuilder<>();
        apiResponseBuilder.success(true)
                .message("degree listing")
                .data("degrees",degrees)
                .statusCode(200);

        return ResponseEntity
                .status(200).body(apiResponseBuilder.build());
    }
}
