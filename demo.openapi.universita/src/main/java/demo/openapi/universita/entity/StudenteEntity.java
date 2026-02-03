package demo.openapi.universita.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "STUDENTI")
//@DiscriminatorValue("STUDENTE")
public class StudenteEntity extends PersonaEntity {

	@NotNull
	@Column(nullable = false)
	@Pattern(regexp = "^S[0-9]{6}$")
	@Size(min = 7, max = 7)
	private String matricola;

	@NotNull
	@Column(nullable = false)
	private String corsoDiLaurea;

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getCorsoDiLaurea() {
		return corsoDiLaurea;
	}

	public void setCorsoDiLaurea(String corsoDiLaurea) {
		this.corsoDiLaurea = corsoDiLaurea;
	}

}
