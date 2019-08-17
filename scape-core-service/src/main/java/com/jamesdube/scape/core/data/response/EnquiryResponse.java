package com.jamesdube.scape.core.data.response;

import com.jamesdube.scape.utils.enums.Classification;
import lombok.Data;

@Data
public class EnquiryResponse {

    private int points;

    private Classification classification;
}
