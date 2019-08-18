package com.jamesdube.scape.core.services.contract;

import com.jamesdube.scape.core.data.Degree;

import java.util.List;

public interface DegreeService {

    Degree findById(Long id);

    List<Degree> findById(List<Long> ids);
}
