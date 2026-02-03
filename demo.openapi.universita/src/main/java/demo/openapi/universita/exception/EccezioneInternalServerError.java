package demo.openapi.universita.exception;

import org.springframework.http.HttpStatus;


public class EccezioneInternalServerError extends EccezioneGlobale {

	private static final long serialVersionUID = 1L;

	
	public EccezioneInternalServerError(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
}
