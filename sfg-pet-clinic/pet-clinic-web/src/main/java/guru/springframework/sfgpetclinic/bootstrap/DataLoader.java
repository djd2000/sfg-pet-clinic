package guru.springframework.sfgpetclinic.bootstrap;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final PetService petService;

//	public DataLoader() {
//		super();
//		ownerService = new OwnerServiceMap();
//		vetService = new VetServiceMap();
//	}

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			PetService petService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public void run(String... args) throws Exception {

		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);

		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);

		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("123 Brickerel");
		owner1.setCity("Miami");
		owner1.setTelephone("123123");
//		owner1.setId(1L);

		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner2.setAddress("123 Brickerel");
		owner2.setCity("Miami");
		owner2.setTelephone("123123");
//		owner2.setId(2L);

		ownerService.save(owner1);

		Pet mikesPet = new Pet();
		mikesPet.setPetType(savedDogPetType);
		mikesPet.setOwner(owner1);
		mikesPet.setBirthDate(LocalDate.now().minusDays(5));
		mikesPet.setName("Rosco");
		petService.save(mikesPet);

		Set<Pet> pets1 = new HashSet<Pet>();
		pets1.add(mikesPet);
		owner1.setPets(pets1);
		ownerService.save(owner1);

		Pet fionasPet = new Pet();
		fionasPet.setPetType(savedCatPetType);
		fionasPet.setOwner(owner2);
		fionasPet.setBirthDate(LocalDate.now().minusYears(1));
		fionasPet.setName("Just Cat");
		petService.save(fionasPet);

		Set<Pet> pets2 = new HashSet<Pet>();
		pets2.add(fionasPet);
		owner2.setPets(pets2);
		ownerService.save(owner2);

		System.out.println("Loaded pet types....");
		for (PetType petType : petTypeService.findAll()) {
			System.out.println(petType.getId() + " " + petType.getName());
		}
		System.out.println();

		ownerService.save(owner2);

		System.out.println("Loaded owners....");
		for (Owner owner : ownerService.findAll()) {
			System.out.println(owner.getId() + " " + owner.getFirstName() + " " + owner.getAddress());
			for (Pet pet : owner.getPets()) {
				System.out.println("\t" + pet.getId() + " " + pet.getPetType().getName() + " " + pet.getBirthDate().toString());
			}
		}
		System.out.println();

		System.out.println("Loaded pets....");
		for (Pet pet : petService.findAll()) {
			System.out.println(pet.getId() + " " + pet.getPetType().getName() + " " + pet.getOwner().getFirstName());
		}
		System.out.println();

		Vet vet1 = new Vet();
//		vet1.setId(1L);
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");

		vetService.save(vet1);

		Vet vet2 = new Vet();
//		vet2.setId(2L);
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");

		vetService.save(vet2);

		System.out.println("Loaded vets....");

	}

}
