package guru.springframework.sfgpetclinic.services;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.Pet;

/**
 * 
 * @author david
 *
 */
public interface PetService {

	Pet findById(Long id);

	Pet save(Pet pet);

	Set<Pet> findAll();
}
