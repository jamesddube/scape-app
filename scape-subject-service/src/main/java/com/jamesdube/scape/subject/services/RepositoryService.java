package com.jamesdube.scape.subject.services;


import com.jamesdube.scape.subject.data.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RepositoryService extends JpaRepository<Subject,Long>, JpaSpecificationExecutor<Subject> {

    Subject findByCode(String code);
}
