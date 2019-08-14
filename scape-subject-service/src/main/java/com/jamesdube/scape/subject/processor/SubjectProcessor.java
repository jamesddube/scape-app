package com.jamesdube.scape.subject.processor;


import com.jamesdube.scape.subject.data.Subject;
import com.jamesdube.scape.subject.data.SubjectWrapper;
import com.jamesdube.scape.utils.api.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SubjectProcessor {

    public ResponseEntity<ApiResponse<List<Subject>>> search(SubjectWrapper subjectWrapper);
}
