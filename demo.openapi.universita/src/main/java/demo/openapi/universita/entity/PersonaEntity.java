package demo.openapi.universita.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "PERSONE")
@Inheritance(strategy = InheritanceType.JOINED)
/*
SINGLE_TABLE: tutte le classi in un’unica tabella con discriminatore.
JOINED: tabella separata per la sottoclasse collegata con join.
TABLE_PER_CLASS: ogni classe ha la propria tabella completa dei campi ereditati.
 */
//@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
//@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
//@JsonSubTypes({
//    @JsonSubTypes.Type(StudenteEntity.class),
//    @JsonSubTypes.Type(DocenteEntity.class)
//})
public class PersonaEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Min(value = 0)
	@Column(nullable = true)
	private Integer id;

	@NotNull
	@Column(nullable = false)
	private String nome;
	
	@NotNull
	@Column(nullable = false)
	private String cognome;
	
	@NotNull
	@Column(nullable = false)
	@Pattern(regexp = "^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]") 
	@Size(min = 16, max = 16)
	private String codiceFiscale;
	
	@NotNull
	@Column(nullable = false)
	private int sesso;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public int getSesso() {
		return sesso;
	}

	public void setSesso(int sesso) {
		this.sesso = sesso;
	}
	
}
