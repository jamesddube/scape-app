package com.jamesdube.scape.core.unit;

import com.jamesdube.scape.core.services.contract.PointsService;
import com.jamesdube.scape.core.services.implementation.SubjectGradePointsService;
import org.junit.Test;

import java.util.Arrays;

import static com.jamesdube.scape.utils.enums.SubjectGrade.*;
import static org.junit.Assert.assertEquals;

public class PointsTest {

    @Test
    public void itCalculatesPoints(){

        PointsService pointsService = new SubjectGradePointsService();

        int points = pointsService.calculatePoints(Arrays.asList(A,B,D));

        assertEquals(11,points);
    }
}
