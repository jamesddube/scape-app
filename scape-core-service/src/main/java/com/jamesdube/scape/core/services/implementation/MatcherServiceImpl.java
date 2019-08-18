package com.jamesdube.scape.core.services.implementation;

import com.jamesdube.scape.core.data.Degree;
import com.jamesdube.scape.core.data.domain.RequirementRule;
import com.jamesdube.scape.core.data.repository.RequirementRuleRepository;
import com.jamesdube.scape.core.services.contract.DegreeService;
import com.jamesdube.scape.core.services.contract.MatcherService;
import com.jamesdube.scape.utils.enums.Classification;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatcherServiceImpl implements MatcherService {

    private RequirementRuleRepository requirementRuleRepository;

    private DegreeService degreeService;

    public MatcherServiceImpl(RequirementRuleRepository requirementRuleRepository, DegreeService degreeService) {
        this.requirementRuleRepository = requirementRuleRepository;
        this.degreeService = degreeService;
    }

    @Override
    public Collection<Degree> match(int points, Classification classification) {

        List<RequirementRule> requirementRules = requirementRuleRepository.findByMinimumPointsLessThanEqual(points);

        Stream<Degree> degrees = requirementRules.stream()
                .map(RequirementRule::getDegreeId)
                .distinct()
                .map(id -> degreeService.findById(id));

        return degrees.collect(Collectors.toList());
    }
}
