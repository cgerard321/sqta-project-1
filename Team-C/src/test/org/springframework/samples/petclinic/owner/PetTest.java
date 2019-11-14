package org.springframework.samples.petclinic.owner;

import org.apache.tomcat.jni.Local;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.configuration.IMockitoConfiguration;
import org.springframework.samples.petclinic.visit.Visit;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PetTest {




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

    //check if the LinkedHashSet contains the right object
    // and not an empty object
    @Test
    void checkifItContains(){
        Visit visitMock = mock(Visit.class);
        visitMock.setPetId(4);
        visitMock.setDescription("myDescription");
        visitMock.setDate(LocalDate.now());
        Pet petClassMock= mock(Pet.class);
        Set<Visit> visits=petClassMock.getVisitsInternal();
        visits.add(visitMock);
        boolean actualResult=visits.contains(visitMock);
        assertTrue(actualResult);

    }
    //checks for the value of petId
    //Supposed to pass since the id given is the expected Id
    @Test
    void checkValuePetIdTrue(){
        Visit visitMock = mock(Visit.class);
        Pet petClassMock= mock(Pet.class);
        when(visitMock.getPetId()).thenReturn(4);

        Set<Visit> visits=petClassMock.getVisitsInternal();
        visits.add(visitMock);

        int expectedResult=4;
        int actualResult=0;
        for(Visit s: visits){
          actualResult= s.getPetId();

        }

        assertEquals(expectedResult,actualResult);

    }

    //checks for the value of petId
    //Supposed to fail since the id given is NOT the expected Id
    @Test
    void checkValuePetIdFalse(){
        Visit visitMock = mock(Visit.class);
        when(visitMock.getPetId()).thenReturn(3);
        Pet petClassMock= mock(Pet.class);
        Set<Visit> visits=petClassMock.getVisitsInternal();
        visits.add(visitMock);
        int expectedResult=4;
        //initialize actual result
        int actualResult=0;
        for(Visit s: visits){
            actualResult= s.getPetId();

        }
        assertEquals(expectedResult,actualResult);

    }



}
