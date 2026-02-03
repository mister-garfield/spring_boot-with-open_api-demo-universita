package demo.openapi.universita.model;

import java.util.Objects;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;

/**
 * Errore generico
 */

@Schema(name = "ErroreImprevisto", description = "Errore generico")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-01T22:35:36.136170+01:00[Europe/Rome]", comments = "Generator version: 7.19.0")
public class ErroreImprevisto {

  private String messaggio;

  private @Nullable String dettaglio;

  public ErroreImprevisto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ErroreImprevisto(String messaggio) {
    this.messaggio = messaggio;
  }

  public ErroreImprevisto messaggio(String messaggio) {
    this.messaggio = messaggio;
    return this;
  }

  /**
   * Messaggio di errore parlante
   * @return messaggio
   */
  @NotNull 
  @Schema(name = "messaggio", description = "Messaggio di errore parlante", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("messaggio")
  public String getMessaggio() {
    return messaggio;
  }

  public void setMessaggio(String messaggio) {
    this.messaggio = messaggio;
  }

  public ErroreImprevisto dettaglio(@Nullable String dettaglio) {
    this.dettaglio = dettaglio;
    return this;
  }

  /**
   * Dettaglio tecnico dell'errore (print stack trace)
   * @return dettaglio
   */
  
  @Schema(name = "dettaglio", description = "Dettaglio tecnico dell'errore (print stack trace)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dettaglio")
  public @Nullable String getDettaglio() {
    return dettaglio;
  }

  public void setDettaglio(@Nullable String dettaglio) {
    this.dettaglio = dettaglio;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErroreImprevisto erroreImprevisto = (ErroreImprevisto) o;
    return Objects.equals(this.messaggio, erroreImprevisto.messaggio) &&
        Objects.equals(this.dettaglio, erroreImprevisto.dettaglio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messaggio, dettaglio);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErroreImprevisto {\n");
    sb.append("    messaggio: ").append(toIndentedString(messaggio)).append("\n");
    sb.append("    dettaglio: ").append(toIndentedString(dettaglio)).append("\n");
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

