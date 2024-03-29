package guru.springframework.sfgpetclinic.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import guru.springframework.sfgpetclinic.model.BaseEntity;
/**
 * 
 * @author david
 *
 * @param <T>
 * @param <ID>
 * 
 * #22
 */
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

	protected Map<Long, T> map = new HashMap<>();

	Set<T> findAll() {
		return new HashSet<>(map.values());
	}

	T findById(ID id) {
		return map.get(id);
	}

	T save(T object) {
		if (object != null) {
			if (object.getId() == null) {
				object.setId(getNextId());
			}
			map.put(object.getId(), object);
		} else {
			throw new RuntimeException("Object cannot be null");
		}

		return object;
	}

	void deleteById(ID id) {
		map.remove(id);

	}

	void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}

	private Long getNextId() {
//      TODO try catch lesson 91
		return map.isEmpty() ? 1L : Collections.max(map.keySet()) + 1;
//		return Collections.max(map.keySet()) + 1; // exception
	}

}
