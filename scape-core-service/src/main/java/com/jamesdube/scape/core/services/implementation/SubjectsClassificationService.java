package com.jamesdube.scape.core.services.implementation;


import com.jamesdube.scape.core.data.Subject;
import com.jamesdube.scape.core.data.request.EnquirySubject;
import com.jamesdube.scape.core.services.contract.ClassificationService;
import com.jamesdube.scape.core.services.contract.SubjectService;
import com.jamesdube.scape.utils.enums.Classification;

import java.util.HashMap;
import java.util.List;

import static com.jamesdube.scape.utils.enums.Classification.*;

public class SubjectsClassificationService implements ClassificationService {

    private SubjectService subjectService;
    private HashMap<String, Classification> hashMap = new HashMap<>();
    private int sciences = 0;
    private int commercials = 0;
    private int arts = 0;

    public SubjectsClassificationService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Override
    public Classification calculate(List<EnquirySubject> enquirySubjects) {

        enquirySubjects.stream()
                .map(EnquirySubject::getSubjectCode )
                .map(this::getSubjectByCode )
                .map(Subject::getClassification)
                .forEach(this::counter);

        if(sciences > commercials){
            if(sciences> arts){
                return SCIENCES;
            }
            else {
                return ARTS;
            }

        }else if(commercials > arts){
            return COMMERCIALS;
        }
        return null;
    }

    private Subject getSubjectByCode(String code){
        return subjectService.findByCode(code);
    }

    private void counter(Classification classification){

        if(classification == SCIENCES){
            sciences += 1;
        }
        else if(classification == ARTS){
            arts += 1;
        }
        else if (classification == COMMERCIALS){
            commercials += 1;
        }
    }
}
