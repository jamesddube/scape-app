package com.jamesdube.scape.degree.data;

import com.jamesdube.scape.utils.enums.Classification;
import lombok.Data;

@Data
public class DegreeWrapper {

    private Long id;

    private String code;

    private String name;

    private Classification classification;

}
