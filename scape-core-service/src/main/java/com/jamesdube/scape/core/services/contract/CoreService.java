package com.jamesdube.scape.core.services.contract;

import com.jamesdube.scape.core.data.request.EnquiryRequest;
import com.jamesdube.scape.core.data.response.EnquiryResponse;

public interface CoreService {

    EnquiryResponse process(EnquiryRequest enquiryRequest);
}
