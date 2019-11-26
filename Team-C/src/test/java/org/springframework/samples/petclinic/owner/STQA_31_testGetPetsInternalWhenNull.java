package org.springframework.samples.petclinic.owner;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class STQA_31_testGetPetsInternalWhenNull {

    @org.junit.jupiter.api.Test
    void getPets() {
        Owner ownerMock = mock(Owner.class);

        List<Pet> petList = ownerMock.getPets();
        int expectedResult = 0;
        int actualResult = petList.size();

        assertEquals(expectedResult,actualResult);
    }
}
