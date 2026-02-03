package demo.openapi.universita.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "DOCENTI")
//@DiscriminatorValue("DOCENTE")
public class DocenteEntity extends PersonaEntity {

	@NotNull 
	@Column(nullable = false)
	@Pattern(regexp = "^D[0-9]{6}$") 
	@Size(min = 7, max = 7) 
	private String matricola;

	@NotNull 
	@Column(nullable = false)
	@Min(value = 1) 
	@Max(value = 30) 
	private Integer anzianita;

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public Integer getAnzianita() {
		return anzianita;
	}

	public void setAnzianita(Integer anzianita) {
		this.anzianita = anzianita;
	}
	
}
