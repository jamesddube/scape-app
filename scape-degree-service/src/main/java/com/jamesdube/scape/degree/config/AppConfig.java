package com.jamesdube.scape.degree.config;

import com.jamesdube.scape.degree.services.DegreeProcessor;
import com.jamesdube.scape.degree.services.DegreeProcessorImpl;
import com.jamesdube.scape.degree.services.DegreeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public DegreeProcessor degreeProcessor(DegreeRepository degreeRepository){
        return new DegreeProcessorImpl(degreeRepository);
    }
}
