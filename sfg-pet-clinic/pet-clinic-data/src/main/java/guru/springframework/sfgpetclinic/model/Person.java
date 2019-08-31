package guru.springframework.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author david
 *
 */
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {

	private static final long serialVersionUID = 1L;
	@Column(name = "first_Name")
	private String firstName;
	@Column(name = "last_Name")
	private String lastName;

	public Person(Long id, String firstName, String lastName) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
