package com.jamesdube.scape.degree.api;

import com.jamesdube.scape.degree.data.Degree;
import com.jamesdube.scape.degree.data.DegreeWrapper;
import com.jamesdube.scape.degree.services.DegreeProcessor;
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
@RequestMapping("api/v1/degrees")
public class DegreeController {

    private DegreeProcessor degreeProcessor;

    public DegreeController(DegreeProcessor degreeProcessor) {
        this.degreeProcessor = degreeProcessor;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<Degree>>> index(
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Classification classification){

        log.info("Received search request for code:[{}], name:[{}]",code,name);
        ResponseEntity<ApiResponse<List<Degree>>> responseEntity =
                degreeProcessor.search(generateWrapper(code, name, classification));

        log.info("Sending search response : {}",toJson(responseEntity));
        return responseEntity;
    }

    private DegreeWrapper generateWrapper(String code, String name, Classification classification) {

        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("name",name);
        hashMap.put("classification",classification);
        hashMap.put("code",code);

        return toObject(hashMap,DegreeWrapper.class);

    }
}
