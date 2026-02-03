package demo.openapi.universita.exception;

import org.springframework.http.HttpStatus;


public class EccezioneMethodNotAllowed extends EccezioneGlobale {

	private static final long serialVersionUID = 1L;

	
	public EccezioneMethodNotAllowed(String message) {
        super(HttpStatus.METHOD_NOT_ALLOWED, message);
    }
}
