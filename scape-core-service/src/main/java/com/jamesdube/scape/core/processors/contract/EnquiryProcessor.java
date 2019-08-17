package com.jamesdube.scape.core.processors.contract;


import com.jamesdube.scape.core.data.request.EnquiryRequest;
import com.jamesdube.scape.utils.api.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface EnquiryProcessor {

    public ResponseEntity<ApiResponse> processEnquiry(EnquiryRequest enquiryRequest);
}
