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
//@Builder
@Entity
@Table(name = "specialties")
public class Speciality extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "description")
	private String description;

}
