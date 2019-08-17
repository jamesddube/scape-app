package com.jamesdube.scape.subject.data;

import com.jamesdube.scape.utils.enums.Classification;
import com.jamesdube.scape.utils.enums.SubjectLevel;
import lombok.Data;

@Data
public class SubjectWrapper {

    private Long id;

    private String code;

    private String name;

    private Classification classification;

    private SubjectLevel subjectLevel;

    public SubjectWrapper() {
    }

    public SubjectWrapper(String code, String name, Classification classification, SubjectLevel subjectLevel) {
        this.code = code;
        this.name = name;
        this.classification = classification;
        this.subjectLevel = subjectLevel;
    }
}