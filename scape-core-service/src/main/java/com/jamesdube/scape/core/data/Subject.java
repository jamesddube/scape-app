package com.jamesdube.scape.core.data;

import com.jamesdube.scape.utils.enums.Classification;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Subject {

    private String code;

    private String name;

    private Classification classification;

    public Subject(String code, Classification classification) {
        this.code = code;
        this.classification = classification;
    }

}
