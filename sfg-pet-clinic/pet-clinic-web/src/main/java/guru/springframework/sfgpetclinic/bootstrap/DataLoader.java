package guru.springframework.sfgpetclinic.bootstrap;

import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final PetService petService;
	private final SpecialityService specialityService;
	private final VisitService visitService;

//	public DataLoader() {
//		super();
//		ownerService = new OwnerServiceMap();
//		vetService = new VetServiceMap();
//	}

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			PetService petService, SpecialityService specialityService, VisitService visitService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.petService = petService;
		this.specialityService = specialityService;
		this.visitService = visitService;
	}

	@Override
	public void run(String... args) throws Exception {

		int count = petService.findAll().size();
		if (count == 0) {
			loadData();
		}

		printData();

	}

	public void printData() {
		System.out.println("Loaded pet types....");
		for (PetType petType : petTypeService.findAll()) {
			System.out.println(petType.getId() + " " + petType.getName());
		}
		System.out.println();

		System.out.println("Loaded owners....");
		for (Owner owner : ownerService.findAll()) {
			System.out.println(owner.getId() + " " + owner.getFirstName() + " " + owner.getAddress());
			for (Pet pet : owner.getPets()) {
				System.out.println("\t" + "PetID:" + pet.getId() + " PetType:" + pet.getPetType().getName() + " "
						+ " PetTypeID:" + pet.getPetType().getId() + " " + pet.getBirthDate().toString());
			}
		}
		System.out.println();

		System.out.println("Loaded pets....");
		for (Pet pet : petService.findAll()) {
			System.out.println(pet.getId() + " " + pet.getPetType().getName() + " " + pet.getOwner().getFirstName());
		}
		System.out.println();

		System.out.println("Loaded vets....");
		vetService.findAll().forEach(vet -> {
			System.out.println(vet.getId() + " " + vet.getFirstName());
			vet.getSpecialities().forEach(specialty -> {
				System.out.println("\t" + specialty.getId() + " " + specialty.getDescription());
			});

		});
	}

	public void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);

		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);

		Speciality radiology = new Speciality();
		radiology.setDescription("radiology");
		Speciality savedRadiology = specialityService.save(radiology);

		Speciality surgery = new Speciality();
		surgery.setDescription("surgery");
		Speciality savedSurgery = specialityService.save(surgery);

		Speciality dentistry = new Speciality();
		dentistry.setDescription("dentistry");
		Speciality savedDentistry = specialityService.save(dentistry);

		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("123 Brickerel");
		owner1.setCity("Miami");
		owner1.setTelephone("123123");
//		owner1.setId(1L);
		Pet mikesPet = new Pet();
		mikesPet.setPetType(savedDogPetType);
//		PetType parrot = new PetType();
//		parrot.setName("Parrot");
//		mikesPet.setPetType(parrot);
		mikesPet.setOwner(owner1);
		mikesPet.setBirthDate(LocalDate.now().minusDays(5));
		mikesPet.setName("Rosco");
		owner1.getPets().add(mikesPet);
		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner2.setAddress("123 Brickerel");
		owner2.setCity("Miami");
		owner2.setTelephone("123123");
//		owner2.setId(2L);
		Pet fionasPet = new Pet();
		fionasPet.setPetType(savedCatPetType);
		fionasPet.setOwner(owner2);
		fionasPet.setBirthDate(LocalDate.now().minusYears(1));
		fionasPet.setName("Just Cat");
		owner2.getPets().add(fionasPet);
		ownerService.save(owner2);

//		ownerService.save(owner1);

//		Pet mikesPet = new Pet();
//		mikesPet.setPetType(savedDogPetType);
//		mikesPet.setOwner(owner1);
//		mikesPet.setBirthDate(LocalDate.now().minusDays(5));
//		mikesPet.setName("Rosco");
//		petService.save(mikesPet);

//		Set<Pet> pets1 = new HashSet<Pet>();
//		pets1.add(mikesPet);
//		owner1.setPets(pets1);
//		ownerService.save(owner1);

//		Pet fionasPet = new Pet();
//		fionasPet.setPetType(savedCatPetType);
//		fionasPet.setOwner(owner2);
//		fionasPet.setBirthDate(LocalDate.now().minusYears(1));
//		fionasPet.setName("Just Cat");
//		petService.save(fionasPet);

//		Set<Pet> pets2 = new HashSet<Pet>();
//		pets2.add(fionasPet);
//		owner2.setPets(pets2);
//		ownerService.save(owner2);

		Vet vet1 = new Vet();
//		vet1.setId(1L);
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.getSpecialities().add(savedRadiology);

		vetService.save(vet1);

		Vet vet2 = new Vet();
//		vet2.setId(2L);
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		vet2.getSpecialities().add(savedSurgery);

		vetService.save(vet2);

		Visit catVisit = new Visit();
		catVisit.setDate(LocalDate.of(2019, 8, 01));
		catVisit.setDescription("Sneezy Kitten");
		catVisit.setPet(fionasPet);

		Visit dogVisit = new Visit();
		dogVisit.setDate(LocalDate.now());
		dogVisit.setDescription("Dog visit");
		dogVisit.setPet(mikesPet);
		visitService.save(dogVisit);

	}

}
