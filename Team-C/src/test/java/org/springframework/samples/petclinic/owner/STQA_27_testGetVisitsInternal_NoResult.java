package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.visit.Visit;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class STQA_27_testGetVisitsInternal_NoResult {

    @Test
        //check if the list is empty
        //supposed to fail because I added an object
    void getVisitsInternalTestNoResult(){
        Visit visitMock = mock(Visit.class);
        visitMock.setPetId(4);
        visitMock.setDescription("myDescription");
        visitMock.setDate(LocalDate.now());
        Pet petClassMock= mock(Pet.class);
        Set<Visit> visits=petClassMock.getVisitsInternal();
        visits.add(visitMock);

        int expectedResult= 0;
        int actualResult=visits.size();
        assertEquals(expectedResult,actualResult);

    }
}
