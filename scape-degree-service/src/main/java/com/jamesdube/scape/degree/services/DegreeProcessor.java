package com.jamesdube.scape.degree.services;

import com.jamesdube.scape.degree.data.Degree;
import com.jamesdube.scape.degree.data.DegreeWrapper;
import com.jamesdube.scape.utils.api.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DegreeProcessor {

    ResponseEntity<ApiResponse<List<Degree>>> search(DegreeWrapper subjectWrapper);

    ResponseEntity<ApiResponse<Degree>> findById(Long id);

}
