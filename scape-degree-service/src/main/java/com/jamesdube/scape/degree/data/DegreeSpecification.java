package com.jamesdube.scape.degree.data;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class DegreeSpecification {

    public static Specification<Degree> filterByWrapper(DegreeWrapper degreeWrapper){

        return (Specification<Degree>) (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if(degreeWrapper.getCode() != null){
                Predicate p = criteriaBuilder.equal(root.get("code"), degreeWrapper.getCode());
                predicates.add(p);
            }

            if(degreeWrapper.getName() != null){
                Predicate p = criteriaBuilder.equal(root.get("name"), degreeWrapper.getName());
                predicates.add(p);
            }

            if(degreeWrapper.getClassification() != null){
                Predicate p = criteriaBuilder.equal(root.get("classification"), degreeWrapper.getClassification());
                predicates.add(p);
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}