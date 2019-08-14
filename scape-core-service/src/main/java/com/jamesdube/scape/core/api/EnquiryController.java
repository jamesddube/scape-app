package com.jamesdube.scape.core.api;


import com.jamesdube.scape.core.data.request.EnquiryRequest;
import com.jamesdube.scape.core.processors.contract.EnquiryProcessor;
import com.jamesdube.scape.utils.api.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.jamesdube.scape.utils.JsonUtil.toJson;

@Slf4j
@RestController
@RequestMapping("api/v1/enquire")
public class EnquiryController {

    private EnquiryProcessor enquiryProcessor;

    public EnquiryController(EnquiryProcessor enquiryProcessor) {
        this.enquiryProcessor = enquiryProcessor;
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse> create(@RequestBody EnquiryRequest enquiryRequest){

        log.info("ENQUIRY REQUEST : \n{}",toJson(enquiryRequest));

        ResponseEntity<ApiResponse> response = enquiryProcessor.processEnquiry(enquiryRequest);

        log.info("ENQUIRY RESPONSE : \n{}",toJson(response));

        return response;

    }

}
