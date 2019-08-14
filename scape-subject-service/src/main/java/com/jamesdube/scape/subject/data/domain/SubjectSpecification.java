package com.jamesdube.scape.subject.data.domain;


import com.jamesdube.scape.subject.data.Subject;
import com.jamesdube.scape.subject.data.SubjectWrapper;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class SubjectSpecification {

    public static Specification<Subject> filterByWrapper(SubjectWrapper subjectWrapper){

        return (Specification<Subject>) (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if(subjectWrapper.getCode() != null){
                Predicate p = criteriaBuilder.equal(root.get("code"), subjectWrapper.getCode());
                predicates.add(p);
            }

            if(subjectWrapper.getName() != null){
                Predicate p = criteriaBuilder.equal(root.get("name"), subjectWrapper.getName());
                predicates.add(p);
            }

            if(subjectWrapper.getClassification() != null){
                Predicate p = criteriaBuilder.equal(root.get("classification"), subjectWrapper.getClassification());
                predicates.add(p);
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}