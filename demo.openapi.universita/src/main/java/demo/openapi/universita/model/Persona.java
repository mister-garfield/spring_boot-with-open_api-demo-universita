package demo.openapi.universita.model;

import java.util.Objects;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Persona
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-01T22:35:36.136170+01:00[Europe/Rome]", comments = "Generator version: 7.19.0")
public class Persona {

  private @Nullable Integer id;

  private String nome;

  private String cognome;

  private String codiceFiscale;

  /**
   * Deve essere 1 sola lettera.  Puo avere solo 3 valori: N sta per neutro, F per femmina, M per maschio. 
   */
  public enum SessoEnum {
    N("N"),
    
    F("F"),
    
    M("M");

    private final String value;

    SessoEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SessoEnum fromValue(String value) {
      for (SessoEnum b : SessoEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private SessoEnum sesso;

  public Persona() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Persona(String nome, String cognome, String codiceFiscale, SessoEnum sesso) {
    this.nome = nome;
    this.cognome = cognome;
    this.codiceFiscale = codiceFiscale;
    this.sesso = sesso;
  }

  public Persona id(@Nullable Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Sarà univoco in quanto chiave primaria (pk) nel database.
   * minimum: 0
   * @return id
   */
  @Min(value = 0) 
  @Schema(name = "id", description = "Sarà univoco in quanto chiave primaria (pk) nel database.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable Integer getId() {
    return id;
  }

  public void setId(@Nullable Integer id) {
    this.id = id;
  }

  public Persona nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Get nome
   * @return nome
   */
  @NotNull 
  @Schema(name = "nome", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nome")
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Persona cognome(String cognome) {
    this.cognome = cognome;
    return this;
  }

  /**
   * Get cognome
   * @return cognome
   */
  @NotNull 
  @Schema(name = "cognome", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("cognome")
  public String getCognome() {
    return cognome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public Persona codiceFiscale(String codiceFiscale) {
    this.codiceFiscale = codiceFiscale;
    return this;
  }

  /**
   * Deve essere univoco.  Codice che identifica una persona a livello nazionale in base a nome, cognome e data di nascita.  E costruito secondo le seguenti regole: 16 caratteri, solo lettere A-Z e numeri 0-9 ordinati secondo le regole dell'agenzia delle entrate. 
   * @return codiceFiscale
   */
  @NotNull @Pattern(regexp = "^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]") @Size(min = 16, max = 16) 
  @Schema(name = "codiceFiscale", description = "Deve essere univoco.  Codice che identifica una persona a livello nazionale in base a nome, cognome e data di nascita.  E costruito secondo le seguenti regole: 16 caratteri, solo lettere A-Z e numeri 0-9 ordinati secondo le regole dell'agenzia delle entrate. ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("codiceFiscale")
  public String getCodiceFiscale() {
    return codiceFiscale;
  }

  public void setCodiceFiscale(String codiceFiscale) {
    this.codiceFiscale = codiceFiscale;
  }

  public Persona sesso(SessoEnum sesso) {
    this.sesso = sesso;
    return this;
  }

  /**
   * Deve essere 1 sola lettera.  Puo avere solo 3 valori: N sta per neutro, F per femmina, M per maschio. 
   * @return sesso
   */
  @NotNull 
  @Schema(name = "sesso", description = "Deve essere 1 sola lettera.  Puo avere solo 3 valori: N sta per neutro, F per femmina, M per maschio. ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("sesso")
  public SessoEnum getSesso() {
    return sesso;
  }

  public void setSesso(SessoEnum sesso) {
    this.sesso = sesso;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Persona persona = (Persona) o;
    return Objects.equals(this.id, persona.id) &&
        Objects.equals(this.nome, persona.nome) &&
        Objects.equals(this.cognome, persona.cognome) &&
        Objects.equals(this.codiceFiscale, persona.codiceFiscale) &&
        Objects.equals(this.sesso, persona.sesso);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, cognome, codiceFiscale, sesso);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Persona {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    cognome: ").append(toIndentedString(cognome)).append("\n");
    sb.append("    codiceFiscale: ").append(toIndentedString(codiceFiscale)).append("\n");
    sb.append("    sesso: ").append(toIndentedString(sesso)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(@Nullable Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

