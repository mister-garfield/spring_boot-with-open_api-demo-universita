package demo.openapi.universita.exception;

import org.springframework.http.HttpStatus;


public abstract class EccezioneGlobale extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final HttpStatus stato;

	
    protected EccezioneGlobale(HttpStatus stato, String messaggio) {
        super(messaggio);
        this.stato = stato;
    }

    public HttpStatus getStatus() {
        return stato;
    }
}

