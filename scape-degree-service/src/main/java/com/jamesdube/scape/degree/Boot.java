package com.jamesdube.scape.degree;

import com.jamesdube.scape.degree.data.Degree;
import com.jamesdube.scape.degree.services.DegreeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static com.jamesdube.scape.utils.enums.Classification.ARTS;
import static com.jamesdube.scape.utils.enums.Classification.SCIENCES;

@Slf4j
@Component
public class Boot implements ApplicationRunner {

    private DegreeRepository degreeRepository;

    public Boot(DegreeRepository degreeRepository) {
        this.degreeRepository = degreeRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        degreeRepository.saveAll(Arrays.asList(
                new Degree("HCS","Computer Science",SCIENCES),
                new Degree("HINFO","Information Systems",SCIENCES),
                new Degree("BA","Bachelor Of Arts",ARTS)
        ));

        log.info("bootstrapped data");
    }
}
