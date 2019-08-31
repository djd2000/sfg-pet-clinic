package guru.springframework.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author david
 *
 */
@Setter
@Getter
@NoArgsConstructor
//@AllArgsConstructor

@Entity
@Table(name = "types")
public class PetType extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "name")
	private String name;

//	@Builder
	public PetType(Long id, String name) {
		super(id);
		this.name = name;
	}

	
}
