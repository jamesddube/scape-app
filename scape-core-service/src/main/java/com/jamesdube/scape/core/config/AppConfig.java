package com.jamesdube.scape.core.config;



import com.jamesdube.scape.core.processors.contract.EnquiryProcessor;
import com.jamesdube.scape.core.processors.implementation.EnquiryProcessorImpl;
import com.jamesdube.scape.core.services.contract.ClassificationService;
import com.jamesdube.scape.core.services.contract.PointsService;
import com.jamesdube.scape.core.services.contract.SubjectService;
import com.jamesdube.scape.core.services.implementation.EnquirySubjectValidator;
import com.jamesdube.scape.core.services.implementation.ScapeSubjectClient;
import com.jamesdube.scape.core.services.implementation.SubjectGradePointsService;
import com.jamesdube.scape.core.services.implementation.SubjectsClassificationService;
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
    public ClassificationService classificationService(SubjectService subjectService){
        return new SubjectsClassificationService(subjectService);
    }

    @Bean
    public EnquiryProcessor enquiryProcessor(PointsService pointsService,
                                             ClassificationService classificationService,
                                             EnquirySubjectValidator enquirySubjectValidator
    ){
        return new EnquiryProcessorImpl(pointsService, classificationService,enquirySubjectValidator);
    }

    @Bean
    public EnquirySubjectValidator enquirySubjectValidator(){
        return new EnquirySubjectValidator();
    }
}
