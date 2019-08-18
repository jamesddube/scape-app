package com.jamesdube.scape.core.services.implementation;

import com.jamesdube.scape.core.data.Degree;
import com.jamesdube.scape.core.data.Subject;
import com.jamesdube.scape.core.services.contract.DegreeService;
import com.jamesdube.scape.utils.api.ApiResponse;
import com.jamesdube.scape.utils.exception.DegreeNotFoundException;
import com.jamesdube.scape.utils.exception.ServiceNotAvailableException;
import com.jamesdube.scape.utils.exception.SubjectNotFoundException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.net.ConnectException;
import java.util.List;
import java.util.Optional;

public class ScapeDegreeClient implements DegreeService {

    private RestTemplate restTemplate;
    private String scapeDegreeServiceUrl;

    public ScapeDegreeClient(RestTemplate restTemplate, Environment environment) {
        this.restTemplate = restTemplate;
        this.scapeDegreeServiceUrl = environment.getRequiredProperty("scape.service.degree.url");
    }

    @Override
    public Degree findById(Long id) {

        try{
        ApiResponse<Degree> response = restTemplate.exchange(scapeDegreeServiceUrl + "/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ApiResponse<Degree>>() {}).getBody();

        if (response != null) {
            return response.getData().get("degree");

//            return optionalDegree.orElseThrow(() -> new DegreeNotFoundException(id));
        }

        throw new RuntimeException("Response is null");
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ServiceNotAvailableException("Failed to connect to Scape Degree service");
        }
    }

    @Override
    public List<Degree> findById(List<Long> ids) {
        return null;
    }
}
