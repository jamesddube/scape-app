package com.jamesdube.scape.core;


import com.jamesdube.scape.core.services.contract.SubjectService;
import org.springframework.context.annotation.Bean;

import static org.mockito.Mockito.mock;

/*@Configuration
@ComponentScan(basePackages = "com.jamesdube.scape.core.service.api")*/
public class TestConfig {

    @Bean
    public SubjectService subjectService(){
        return mock(SubjectService.class);
    }
}
