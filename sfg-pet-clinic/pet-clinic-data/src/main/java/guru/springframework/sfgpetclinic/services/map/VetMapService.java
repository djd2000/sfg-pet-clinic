package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;

@Service
@Profile({"default","map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

	SpecialtyMapService specialtyService;

	public VetMapService(SpecialtyMapService specialtyService) {
		super();
		this.specialtyService = specialtyService;
	}

//	@Override
//	public Owner save(Vet object) {
//		return null;
//	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Vet save(Vet object) {
		if (object != null) {
			if (object.getSpecialities().size() > 0) {
				object.getSpecialities().forEach(specialty -> {
					if(specialty.getId()== null) {
						specialty.setId(specialtyService.save(specialty).getId());
					}
					
				});
			}
			return super.save(object);
		} else {
			return null;
		}

	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

	@Override
	public Vet findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
