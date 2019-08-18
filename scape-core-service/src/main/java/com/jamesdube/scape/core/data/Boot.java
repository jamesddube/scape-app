package com.jamesdube.scape.core.data;

import com.jamesdube.scape.core.data.domain.RequirementRule;
import com.jamesdube.scape.core.data.repository.RequirementRuleRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static com.jamesdube.scape.utils.enums.Classification.SCIENCES;


@Component
public class Boot implements ApplicationRunner {

    private RequirementRuleRepository requirementRuleRepository;

    public Boot(RequirementRuleRepository requirementRuleRepository) {
        this.requirementRuleRepository = requirementRuleRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {


        List<RequirementRule> requirementRules = Arrays.asList(
                new RequirementRule(1L,7),
                new RequirementRule(2L,10),
                new RequirementRule(3L,14),
                new RequirementRule(4L,6),
                new RequirementRule(5L,5)
        );

        requirementRuleRepository.saveAll(requirementRules);
    }
}
