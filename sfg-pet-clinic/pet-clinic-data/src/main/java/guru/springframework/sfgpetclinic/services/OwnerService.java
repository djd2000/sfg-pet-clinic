package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;

/**
 * 
 * @author david
 * 2 generic types mapped to type and id
 */
public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);
}
