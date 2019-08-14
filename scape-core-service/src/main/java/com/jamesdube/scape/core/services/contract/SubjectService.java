package com.jamesdube.scape.core.services.contract;


import com.jamesdube.scape.core.data.Subject;

import java.util.List;

public interface SubjectService {

    public List<Subject> all();

    public Subject findByCode(String code);
}
