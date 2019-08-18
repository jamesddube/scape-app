package com.jamesdube.scape.degree;

import com.jamesdube.scape.degree.data.Degree;
import com.jamesdube.scape.degree.services.DegreeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static com.jamesdube.scape.utils.enums.Classification.*;

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
                new Degree("HTEL","Telecommunications",SCIENCES),
                new Degree("HACC","Accounting",COMMERCIALS),
                new Degree("HBUS","Business Studies",COMMERCIALS),
                new Degree("HECO","Economics",SCIENCES),
                new Degree("HENG","English And Communication",ARTS),
                new Degree("HMUS","Musicology",ARTS),
                new Degree("HHST","History",ARTS),
                new Degree("HRM","Human Resources",ARTS),
                new Degree("HMKT","Marketing",COMMERCIALS),
                new Degree("BA","Bachelor Of Arts",ARTS)
        ));

        log.info("bootstrapped data");
    }
}
