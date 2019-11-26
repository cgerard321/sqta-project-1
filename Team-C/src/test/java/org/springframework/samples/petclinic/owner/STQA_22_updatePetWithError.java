package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class STQA_22_updatePetWithError {
@Test
    void testPetController_updatePet_withError(){
    PetRepository pets = mock(PetRepository.class);
    OwnerRepository owners = mock(OwnerRepository.class);

    PetController petController = new PetController(pets,owners);
    Pet petMock = mock(Pet.class);
    Owner ownerMock = mock(Owner.class);
    BindingResult bResMock = mock(BindingResult.class);
    ModelMap mMapMock = mock(ModelMap.class);


    when(bResMock.hasErrors()).thenReturn(true);
    String expectedResult = "pets/createOrUpdatePetForm";
    String actualResult = petController.processUpdateForm(petMock,bResMock,ownerMock,mMapMock);
    assertEquals(expectedResult,actualResult);



}
}
