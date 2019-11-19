package org.springframework.samples.petclinic.owner;
import static org.mockito.Mockito.mock;


import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class OwnerTest {

    //checks for the value of petId
    //Supposed to pass since the id given is the expected Id
    @org.junit.jupiter.api.Test
    void getPetsInternalusingAMock() {


        Owner ownerMock = mock(Owner.class);
        Pet petMock = mock(Pet.class);
        when(petMock.getId()).thenReturn(3);

        Set<Pet> pets = ownerMock.getPetsInternal();
        pets.add(petMock);

        int expectedResult = 3;
        int actualResult = 0;
        for (Pet p: pets){
            actualResult = p.getId();
        }

        assertEquals(expectedResult,actualResult);
    }

    //check if it gets the list if its empty
    // suppose to pass
    @org.junit.jupiter.api.Test
    void getPets() {
        Owner ownerMock = mock(Owner.class);

        List<Pet> petList = ownerMock.getPets();
        int expectedResult = 0;
        int actualResult = petList.size();

        assertEquals(expectedResult,actualResult);
    }
}
