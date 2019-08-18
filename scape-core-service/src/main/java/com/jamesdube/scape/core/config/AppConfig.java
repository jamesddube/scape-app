package com.jamesdube.scape.core.config;



import com.jamesdube.scape.core.data.repository.RequirementRuleRepository;
import com.jamesdube.scape.core.processors.contract.EnquiryProcessor;
import com.jamesdube.scape.core.processors.implementation.EnquiryProcessorImpl;
import com.jamesdube.scape.core.services.contract.*;
import com.jamesdube.scape.core.services.implementation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public PointsService pointsService(){
        return new SubjectGradePointsService();
    }

    @Bean
    public SubjectService subjectService(Environment environment){
        return new ScapeSubjectClient(new RestTemplate(),environment);
    }

    @Bean
    public DegreeService degreeService(Environment environment){
        return new ScapeDegreeClient(new RestTemplate(),environment);
    }

    @Bean
    public ClassificationService classificationService(SubjectService subjectService){
        return new SubjectsClassificationService(subjectService);
    }

    @Bean
    public CoreService coreService(PointsService pointsService,ClassificationService classificationService,
                                   MatcherService matcherService){
        return new CoreServiceImpl(pointsService,classificationService,matcherService);
    }

    @Bean
    public EnquiryProcessor enquiryProcessor(CoreService coreService,EnquirySubjectValidator enquirySubjectValidator){
        return new EnquiryProcessorImpl(coreService,enquirySubjectValidator);
    }

    @Bean
    public EnquirySubjectValidator enquirySubjectValidator(){
        return new EnquirySubjectValidator();
    }

    @Bean
    public MatcherService matcherService(RequirementRuleRepository requirementRuleRepository,DegreeService degreeService){
        return new MatcherServiceImpl(requirementRuleRepository, degreeService);
    }
}
