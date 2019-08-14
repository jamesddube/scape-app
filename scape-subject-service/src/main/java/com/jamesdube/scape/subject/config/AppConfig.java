package com.jamesdube.scape.subject.config;


import com.jamesdube.scape.subject.processor.SubjectProcessor;
import com.jamesdube.scape.subject.processor.implementation.ScapeSubjectProcessor;
import com.jamesdube.scape.subject.services.RepositoryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public SubjectProcessor subjectProcessor(RepositoryService repositoryService){
        return new ScapeSubjectProcessor(repositoryService);
    }
}
