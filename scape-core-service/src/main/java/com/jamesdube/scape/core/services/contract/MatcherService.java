package com.jamesdube.scape.core.services.contract;

import com.jamesdube.scape.core.data.Degree;
import com.jamesdube.scape.utils.enums.Classification;

import java.util.Collection;

public interface MatcherService {

    Collection<Degree> match(int points, Classification classification);
}
