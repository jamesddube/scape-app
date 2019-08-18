package com.jamesdube.scape.core.data.response;

import com.jamesdube.scape.core.data.Degree;
import com.jamesdube.scape.utils.enums.Classification;
import lombok.Data;

import java.util.Collection;

@Data
public class EnquiryResponse {

    private int points;

    private Classification classification;

    private Collection<Degree> degrees;
}
