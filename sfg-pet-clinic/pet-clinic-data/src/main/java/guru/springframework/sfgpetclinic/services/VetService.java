package guru.springframework.sfgpetclinic.services;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;

/**
 * 
 * @author david
 *
 */
public interface VetService {
	Vet findByLastName(String lastName);

	Vet findById(Long id);

	Vet save(Vet vet);

	Set<Vet> findAll();
}
