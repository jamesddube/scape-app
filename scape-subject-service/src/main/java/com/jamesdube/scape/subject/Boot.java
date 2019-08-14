package com.jamesdube.scape.subject;

import com.jamesdube.scape.subject.data.Subject;
import com.jamesdube.scape.subject.services.RepositoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static com.jamesdube.scape.utils.enums.Classification.SCIENCES;


@Slf4j
@Component
public class Boot implements ApplicationRunner {

    @Autowired
    private RepositoryService repositoryService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        repositoryService.saveAll(Arrays.asList(
                new Subject("A-MAT","Mathematics",SCIENCES),
                new Subject("A-PHY","Physics",SCIENCES),
                new Subject("A-CHE","Chemistry",SCIENCES)
        ));

        log.info("bootstrapped data");
    }
}
