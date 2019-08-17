package com.jamesdube.scape.degree.services;

import com.jamesdube.scape.degree.data.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DegreeRepository extends JpaRepository<Degree,Long>, JpaSpecificationExecutor<Degree>  {
}
