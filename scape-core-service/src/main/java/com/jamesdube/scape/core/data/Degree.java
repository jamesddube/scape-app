package com.jamesdube.scape.core.data;

import com.jamesdube.scape.utils.enums.Classification;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Degree {

    private String code;

    private String name;

    private Classification classification;

    public Degree(String code, Classification classification) {
        this.code = code;
        this.classification = classification;
    }
}
