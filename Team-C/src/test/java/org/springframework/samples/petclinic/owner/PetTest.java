package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    @Test
    void set_owner_usingAMock() {
        //get a mock of the TodoService class
        //Owner ownerMock = mock(Owner.class);

        Owner ownerTest = new Owner();

        ownerTest.setId(44);
        ownerTest.setCity("Mtl");

        String expectedResult = "Mtl";

        Pet pet = new Pet();
        pet.setOwner(ownerTest);

        //Owner ownerActual = pet.getOwner();

        String actualResult = pet.getOwner().getCity();
        //int actualResult = petMock.getOwner().getId();

        assertEquals(expectedResult,actualResult);

        // set id get id for testing

    }

}
