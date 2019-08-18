package com.jamesdube.scape.core.data.repository;

import com.jamesdube.scape.core.data.domain.RequirementRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequirementRuleRepository extends JpaRepository<RequirementRule,Long> {

    List<RequirementRule> findByMinimumPointsLessThanEqual(int points);
}
