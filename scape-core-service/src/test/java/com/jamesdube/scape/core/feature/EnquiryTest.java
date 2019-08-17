package com.jamesdube.scape.core.feature;


import com.jamesdube.scape.core.AppTest;
import com.jamesdube.scape.core.data.Subject;
import com.jamesdube.scape.core.data.request.EnquiryRequest;
import com.jamesdube.scape.core.data.request.EnquirySubject;
import com.jamesdube.scape.core.services.contract.SubjectService;
import com.jamesdube.scape.utils.exception.SubjectNotFoundException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static com.jamesdube.scape.utils.JsonUtil.toJson;
import static com.jamesdube.scape.utils.enums.Classification.ARTS;
import static com.jamesdube.scape.utils.enums.Classification.SCIENCES;
import static com.jamesdube.scape.utils.enums.SubjectGrade.A;
import static com.jamesdube.scape.utils.enums.SubjectGrade.B;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EnquiryTest extends AppTest {

    private Subject maths;
    private Subject physics;
    private Subject chemistry;
    private Subject history;
    private Subject shona;
    private Subject literature;

    @Autowired
    private SubjectService subjectService;

    @Test
    public void itGetsResultsForAnEnquiry() throws Exception{

        List<EnquirySubject> enquirySubjectList = new ArrayList<>();

        initMocks();

        enquirySubjectList.add(new EnquirySubject("A-MAT",A));
        enquirySubjectList.add(new EnquirySubject("A-PHY",B));
        enquirySubjectList.add(new EnquirySubject("A-CHE",A));

        EnquiryRequest enquiryRequest = new EnquiryRequest();
        enquiryRequest.setSubjectList(enquirySubjectList);
        mockMvc.perform(post("/api/v1/enquire")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(toJson(enquiryRequest)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("enquiry successful"))
                .andExpect(jsonPath("$.data.enquiryResponse.points").value(14))
                .andExpect(jsonPath("$.data.enquiryResponse.classification").value("SCIENCES"));


    }

    @Test
    public void itReturnsAnErrorForAnUnknownSubject() throws Exception{

        List<EnquirySubject> enquirySubjectList = new ArrayList<>();

        initMocks();

        when(subjectService.findByCode("UNKNOWN_2")).thenThrow(new SubjectNotFoundException("UNKNOWN_2"));

        enquirySubjectList.add(new EnquirySubject("UNKNOWN_2",A));

        EnquiryRequest enquiryRequest = new EnquiryRequest();
        enquiryRequest.setSubjectList(enquirySubjectList);
        mockMvc.perform(post("/api/v1/enquire")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(toJson(enquiryRequest)))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.message")
                        .value("could not find subject using the subject-code UNKNOWN_2"));

    }

    @Test
    public void itReturnsAnErrorForAnUnknownSubjectGrade() throws Exception{

        List<EnquirySubject> enquirySubjectList = new ArrayList<>();

        initMocks();

//        when(subjectService.findByCode("UNKNOWN")).thenThrow(new SubjectNotFoundException("UNKNOWN"));

        EnquirySubject enquirySubject = new EnquirySubject();
        enquirySubject.setSubjectCode("A-MAT");
        enquirySubjectList.add(enquirySubject);
        enquirySubjectList.add(new EnquirySubject("A-PHY",B));
        enquirySubjectList.add(new EnquirySubject("A-CHE",A));

        EnquiryRequest enquiryRequest = new EnquiryRequest();
        enquiryRequest.setSubjectList(enquirySubjectList);
        mockMvc.perform(post("/api/v1/enquire")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(toJson(enquiryRequest)))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.message")
                        .value("invalid grade for subject A-MAT"));

    }

    private void initMocks() {
        maths = new Subject("A-MAT",SCIENCES);
        physics = new Subject("A-PHY",SCIENCES);
        chemistry = new Subject("A-CHE",SCIENCES);
        history = new Subject("A-HIS",ARTS);
        shona = new Subject("A-SHO",ARTS);
        literature = new Subject("A-LIT",ARTS);

        subjectService = mock(SubjectService.class);

        when(subjectService.findByCode(maths.getCode())).thenReturn(maths);
        when(subjectService.findByCode(physics.getCode())).thenReturn(physics);
        when(subjectService.findByCode(chemistry.getCode())).thenReturn(chemistry);
        when(subjectService.findByCode(history.getCode())).thenReturn(history);
        when(subjectService.findByCode(literature.getCode())).thenReturn(literature);
        when(subjectService.findByCode(shona.getCode())).thenReturn(shona);
    }
}
