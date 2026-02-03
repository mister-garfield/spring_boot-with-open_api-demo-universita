package demo.openapi.universita.exception;

import org.springframework.http.HttpStatus;


public class EccezioneNotFound extends EccezioneGlobale {

	private static final long serialVersionUID = 1L;

	
	public EccezioneNotFound() {
        super(HttpStatus.NOT_FOUND, "Nessuna risorsa presente con le caratteristiche cercate");
    }
	
	public EccezioneNotFound(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
	
}
