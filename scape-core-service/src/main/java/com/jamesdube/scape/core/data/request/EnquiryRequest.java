package com.jamesdube.scape.core.data.request;

import lombok.Data;

import java.util.List;

@Data
public class EnquiryRequest {

    private List<EnquirySubject> subjectList;
}
