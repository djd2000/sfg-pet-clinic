package guru.springframework.sfgpetclinic.model;


import java.time.LocalDate;

public class Pet {
	private PetType pet;
	private Owner owner;
	private LocalDate birthDate;

	public PetType getPet() {
		return pet;
	}

	public void setPet(PetType pet) {
		this.pet = pet;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

}
