package com.jamesdube.scape.subject.api;


import com.jamesdube.scape.subject.data.Subject;
import com.jamesdube.scape.subject.data.SubjectWrapper;
import com.jamesdube.scape.subject.processor.SubjectProcessor;
import com.jamesdube.scape.utils.api.ApiResponse;
import com.jamesdube.scape.utils.enums.Classification;
import com.jamesdube.scape.utils.enums.SubjectLevel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

import static com.jamesdube.scape.utils.JsonUtil.toJson;
import static com.jamesdube.scape.utils.JsonUtil.toObject;

@Slf4j
@RestController
@RequestMapping("api/v1/subjects")
public class SubjectController {

    private SubjectProcessor subjectProcessor;

    public SubjectController(SubjectProcessor subjectProcessor) {
        this.subjectProcessor = subjectProcessor;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<Subject>>> index(
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Classification classification,
            @RequestParam(required = false) SubjectLevel subjectLevel){

        log.info("Received search request for code:[{}], name:[{}]",code,name);
        ResponseEntity<ApiResponse<List<Subject>>> responseEntity =
                subjectProcessor.search(generateWrapper(code, name, classification, subjectLevel));

        log.info("Sending search response : {}",toJson(responseEntity));
        return responseEntity;

        /*List<Subject> subjects =  subjectService.all(generateWrapper(code,name,type));

        SubjectListResponse subjectListResponse = convert(subjects);

        return ResponseEntity.status(200)
                .body(subjectListResponse);*/
    }

    private SubjectWrapper generateWrapper(String code, String name, Classification classification, SubjectLevel subjectLevel) {


        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("name",name);
        hashMap.put("code",code);
        hashMap.put("classification",classification);

        return toObject(hashMap,SubjectWrapper.class);

    }
}
