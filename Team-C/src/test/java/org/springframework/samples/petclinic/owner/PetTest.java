package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

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
