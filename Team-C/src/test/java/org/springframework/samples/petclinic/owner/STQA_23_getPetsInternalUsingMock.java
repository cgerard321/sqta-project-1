package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class STQA_23_getPetsInternalUsingMock {

    //checks for the value of petId
    //Supposed to pass since the id given is the expected Id
    @Test
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

}
