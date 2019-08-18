package com.jamesdube.scape.core.data.domain;

import com.jamesdube.scape.utils.enums.Classification;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ClassificationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="requirement_rule_id")
    private RequirementRule requirementRule;

    /*@ManyToOne
    @JoinColumn(name="library_id")
    private Library library;*/

    @Enumerated(value = EnumType.STRING)
    private Classification classification;
}
