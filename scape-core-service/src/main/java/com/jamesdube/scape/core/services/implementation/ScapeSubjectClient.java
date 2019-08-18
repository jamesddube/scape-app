package com.jamesdube.scape.core.services.implementation;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jamesdube.scape.core.data.Subject;
import com.jamesdube.scape.core.services.contract.SubjectService;
import com.jamesdube.scape.utils.api.ApiResponse;
import com.jamesdube.scape.utils.exception.ServiceNotAvailableException;
import com.jamesdube.scape.utils.exception.SubjectNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Slf4j
public class ScapeSubjectClient implements SubjectService {

    private RestTemplate restTemplate;
    private String scapeSubjectServiceUrl;
    private ObjectMapper mapper;

    public ScapeSubjectClient(RestTemplate restTemplate, Environment environment) {
        this.restTemplate = restTemplate;
        this.scapeSubjectServiceUrl = environment.getRequiredProperty("scape.service.subject.url");
    }

    @Override
    public List<Subject> all() {
        return null;
    }

    @Override
    public Subject findByCode(String code) {

        try{
        ApiResponse<List<Subject>> response = restTemplate.exchange(scapeSubjectServiceUrl + "?code=" + code,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ApiResponse<List<Subject>>>() {}).getBody();

        if (response != null) {
            Optional<Subject> optionalSubject = response.getData().get("subjects")
                    .stream()
                    .findFirst();
            if(optionalSubject.isPresent()){
                return optionalSubject.get();
            }
            else {
                throw new SubjectNotFoundException(code);
            }
        }

        throw new RuntimeException("Response is null");
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ServiceNotAvailableException("Failed to connect to Scape Subject service");
        }

    }
}
