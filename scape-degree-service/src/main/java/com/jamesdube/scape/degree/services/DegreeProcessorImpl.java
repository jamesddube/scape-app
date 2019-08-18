package com.jamesdube.scape.degree.services;

import com.jamesdube.scape.degree.data.Degree;
import com.jamesdube.scape.degree.data.DegreeSpecification;
import com.jamesdube.scape.degree.data.DegreeWrapper;
import com.jamesdube.scape.utils.api.ApiResponse;
import com.jamesdube.scape.utils.api.ApiResponseBuilder;
import com.jamesdube.scape.utils.exception.DegreeNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static com.jamesdube.scape.utils.api.ApiResponseBuilder.newApiResponseBuilder;

public class DegreeProcessorImpl implements DegreeProcessor {

    private DegreeRepository degreeRepository;

    public DegreeProcessorImpl(DegreeRepository degreeRepository) {
        this.degreeRepository = degreeRepository;
    }

    @Override
    public ResponseEntity<ApiResponse<Degree>> findById(Long id) {

        Optional<Degree> optionalDegree = degreeRepository.findById(id);

        if(optionalDegree.isPresent()){

            ApiResponseBuilder<Degree> apiResponseBuilder = new ApiResponseBuilder<>();
            apiResponseBuilder.success(true)
                    .message("degree listing")
                    .data("degree",optionalDegree.get())
                    .statusCode(200);

            return ResponseEntity
                    .status(200).body(apiResponseBuilder.build());
        }
        else {
            throw new DegreeNotFoundException(id);
        }
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
