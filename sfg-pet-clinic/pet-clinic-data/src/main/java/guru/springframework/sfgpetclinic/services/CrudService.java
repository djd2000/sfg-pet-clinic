package guru.springframework.sfgpetclinic.services;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.Owner;
/**
 * mimic Crudrepository
 * @author david
 *
 * @param <T>
 * @param <ID>
 */
public interface CrudService <T, ID>{

	Set<T> findAll();

	Owner findById(ID id);

	Owner save(T object);

	void delete(T object);
	
	void deleteById(ID id);
}