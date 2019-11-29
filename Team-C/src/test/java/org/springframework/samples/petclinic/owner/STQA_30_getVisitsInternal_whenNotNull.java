package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.visit.Visit;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class STQA_30_getVisitsInternal_whenNotNull {
    //check if the list has an item
    //supposed to create because new set<Visit> null is added to visits
    @Test
    void getVisitsInternalTestLookForResult(){
        Pet petClassMock= mock(Pet.class);
        Set<Visit> visits=petClassMock.getVisitsInternal();
        visits.add(null);
        int expectedResult= 1;
        int actualResult=visits.size();
        assertEquals(expectedResult,actualResult);

    }



    }




