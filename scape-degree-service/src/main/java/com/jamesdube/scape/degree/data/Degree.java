package com.jamesdube.scape.degree.data;

import com.jamesdube.scape.utils.enums.Classification;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Degree {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Enumerated(value = EnumType.STRING)
    private Classification classification;

    public Degree(String code, String name, Classification classification) {
        this.name = name;
        this.code = code;
        this.classification = classification;
    }
}
