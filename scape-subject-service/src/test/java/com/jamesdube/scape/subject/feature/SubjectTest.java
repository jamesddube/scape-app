package com.jamesdube.scape.subject.feature;

import com.jamesdube.scape.subject.AppTest;
import com.jamesdube.scape.subject.data.Subject;
import com.jamesdube.scape.subject.services.RepositoryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.awt.*;
import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SubjectTest extends AppTest {

    @Autowired
    private RepositoryService repositoryService;

    @Test
    public void itListsAllSubjects() throws Exception {

        repositoryService.deleteAll();
        repositoryService.saveAll(
                Arrays.asList(
                        new Subject("HCS", "Computer Science"),
                        new Subject( "HINFO", "Information Systems")));

        this.mockMvc.perform(get("/api/v1/subjects")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("data.subjects").isArray())
                .andExpect(jsonPath("data.subjects", hasSize(2)))
                .andExpect(jsonPath("data.subjects[?(@.code==\"HCS\")]").exists())
                .andExpect(jsonPath("data.subjects[?(@.code==\"HINFO\")]").exists())
                .andExpect(jsonPath("data.subjects", hasSize(2)));

        assertEquals(2,repositoryService.findAll().size());

    }

    @Test
    public void itListsAllSubjectsByType() throws Exception {

        repositoryService.deleteAll();
        repositoryService.saveAll(
                Arrays.asList(
                        new Subject("HACC", "Accounting"),
                        new Subject("HCS", "Computer Science"),
                        new Subject( "HINFO", "Information Systems")));

        this.mockMvc.perform(get("/api/v1/subjects?code=HCS")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("data.subjects").isArray())
                .andExpect(jsonPath("data.subjects", hasSize(1)))
                .andExpect(jsonPath("data.subjects[?(@.code==\"HCS\")]").exists())
                .andExpect(jsonPath("data.subjects[?(@.name==\"Computer Science\")]").exists());

        assertEquals(3,repositoryService.findAll().size());

    }
}