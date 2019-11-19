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

    //check for the description
    //supposed to pass expected and actual description are the same
    @Test
    void checkValueDescriptionTrue() {
        Visit visitMock = mock(Visit.class);
        Pet petClassMock=mock(Pet.class);
        when(visitMock.getDescription()).thenReturn("myDescription");
        Set<Visit> visits = petClassMock.getVisitsInternal();
        visits.add(visitMock);
        String  expectedResult = "myDescription";
        String actualResult="";

        for(Visit v:visits){
            actualResult=v.getDescription();
        }

        assertEquals(expectedResult,actualResult);

    }

    //check for the description
    //supposed to pass fail and actual description are NOT the same
    @Test
    void checkValueDescriptionFalse() {
        Visit visitMock = mock(Visit.class);
        Pet petClassMock=mock(Pet.class);
        when(visitMock.getDescription()).thenReturn("Hello");
        Set<Visit> visits = petClassMock.getVisitsInternal();
        visits.add(visitMock);
        String  expectedResult = "myDescription";
        String actualResult="";

        for(Visit v:visits){
            actualResult=v.getDescription();
        }

        assertEquals(expectedResult,actualResult);

    }



    //checks for the value of the date
    //supposed to fail, date returned and expected date are NOT the same
    @Test
    void checkValueDateSame(){
        Visit visitMock = mock(Visit.class);
        Pet petClassMock= mock(Pet.class);
        when(visitMock.getDate()).thenReturn(LocalDate.now());

        Set<Visit> visits=petClassMock.getVisitsInternal();
        visits.add(visitMock);
    //initialize
        LocalDate  expectedResult=LocalDate.now();
        LocalDate  actualResult=LocalDate.now();

        for(Visit s: visits){
            actualResult= s.getDate();

        }
        assertEquals(expectedResult,actualResult);


    }
    //check if the dates match
    //supposed to pass since actualResult is different from expectedResult
    @Test
    void checkValueDateDifferent(){
        Visit visitMock = mock(Visit.class);
        visitMock.setPetId(4);
        visitMock.setDescription("myDescription");
        visitMock.setDate(LocalDate.now());
        Pet petClassMock= mock(Pet.class);
        Set<Visit> visits=petClassMock.getVisitsInternal();
        //initialize
        LocalDate  expectedResult=LocalDate.ofYearDay(2019,25);

        for(Visit s: visits){
            LocalDate actualResult= s.getDate();
            assertNotEquals(expectedResult,actualResult);
        }


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
    //Supposed to pass since the id given is the same as the expected Id
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
    //Supposed to pass since the id given is NOT the expected Id
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
        assertNotEquals(expectedResult,actualResult);

    }



}
