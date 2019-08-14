package com.jamesdube.scape.subject.data;

import com.jamesdube.scape.utils.enums.Classification;
import com.jamesdube.scape.utils.enums.SubjectLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Enumerated(value = EnumType.STRING)
    private Classification classification;

    @Enumerated(value = EnumType.STRING)
    private SubjectLevel subjectLevel;

    public Subject(String code, String name) {
        this.name = name;
        this.code = code;
    }
    public Subject(String code, String name,Classification classification) {
        this.name = name;
        this.code = code;
        this.classification =classification;
    }

}
