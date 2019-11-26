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


    //Test to see if we can successfully set and get the right pet type
    @Test
    void getType() {

        // Arrange

        String expectedResult = "Dog";

        Pet petTest = new Pet();

        PetType type = new PetType();
        type.setName("Dog");

        //Act

        petTest.setType(type);

        //assert

        assertEquals(expectedResult, petTest.getType().getName());

    }

}
