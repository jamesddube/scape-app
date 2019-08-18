package com.jamesdube.scape.core.data.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "requirement_rule")
@NoArgsConstructor
public class RequirementRule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "degree_id")
    private Long degreeId;

    @Column(name = "minimum_points")
    private int minimumPoints;

    @OneToMany(mappedBy = "requirementRule")
    private Collection<ClassificationRule> classificationRules;

    public RequirementRule(long degreeId, int minimumPoints) {
        this.degreeId = degreeId;
        this.minimumPoints = minimumPoints;
    }

    public RequirementRule(long degreeId, int minimumPoints, Collection<ClassificationRule> classificationRules) {
        this.degreeId = degreeId;
        this.minimumPoints = minimumPoints;
        this.classificationRules = classificationRules;
    }
}
