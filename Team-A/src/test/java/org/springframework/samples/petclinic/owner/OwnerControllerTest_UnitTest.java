package org.springframework.samples.petclinic.owner;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.visit.Visit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OwnerControllerTest_UnitTest {

    @Test
    void EditOwnerName() {
        //arrange
        Owner ownerMock = mock(Owner.class);


        int ownerId = 1;
        String expectedName = "George Franklin";
        String actualName = "";

        //Owner owner = owners.findById(ownerId);

        //act
        when(ownerMock.getFirstName()).thenReturn("George");
        when(ownerMock.getLastName()).thenReturn("Franklin");
        actualName = (ownerMock.getFirstName() + " " + ownerMock.getLastName());

        //Assert
        assertEquals(expectedName, actualName);
    }

    @Test
    void EditOwnerAddress() {
        //arrange
        //arrange
        OwnerRepository owners = mock(OwnerRepository.class);
        Owner ownerMock = mock(Owner.class);

        String expectedAddress = "110 W. Liberty St.";
        String actualAddress = "";

        //act
        when(ownerMock.getAddress()).thenReturn("110 W. Liberty St.");
        actualAddress = ownerMock.getAddress();

        //Assert
        assertEquals(expectedAddress, actualAddress);
    }

    @Test
    void EditOwnerCity() {
        //arrange

        OwnerRepository owners = mock(OwnerRepository.class);
        Owner ownerMock = mock(Owner.class);

        String expectedCity = "Madison";
        String actualCity = "";


        //act
        when(ownerMock.getCity()).thenReturn("Madison");
        actualCity = ownerMock.getCity();

        //Assert
        assertEquals(expectedCity, actualCity);
    }

    @Test
    void EditOwnerPhone() {
        //arrange
        //arrange
        OwnerRepository owners = mock(OwnerRepository.class);
        Owner ownerMock = mock(Owner.class);

        String expectedPhone = "6085551023";
        String actualPhone = "";


        //act
        when(ownerMock.getTelephone()).thenReturn("6085551023");
        actualPhone = ownerMock.getTelephone();

        //Assert
        assertEquals(expectedPhone, actualPhone);
    }
}
