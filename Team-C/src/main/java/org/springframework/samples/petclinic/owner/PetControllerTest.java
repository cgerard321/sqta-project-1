package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PetControllerTest {

    @Test
    void processUpdateForm() {
        //arrange
        String expectedResult="redirect:/owners/{ownerId}";

        Pet pet = mock(Pet.class);
        Owner owner = mock(Owner.class);
        PetRepository pets = mock(PetRepository.class);
        OwnerRepository owners = mock(OwnerRepository.class);
        PetController petController = new PetController(pets,owners);
        ModelMap model = new ModelMap();

        BindingResult bindingResult = mock(BindingResult.class);

        String actualResult;
        //act
        when(bindingResult.hasErrors()).thenReturn(false);
        actualResult = petController.processUpdateForm(pet,bindingResult,owner,model);
        //assert

        assertEquals(expectedResult,actualResult);
    }

}
