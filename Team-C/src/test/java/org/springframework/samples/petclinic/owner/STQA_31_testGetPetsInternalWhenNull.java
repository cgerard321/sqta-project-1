package org.springframework.samples.petclinic.owner;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OwnerTest {

    /
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
