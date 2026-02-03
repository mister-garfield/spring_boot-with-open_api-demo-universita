package demo.openapi.universita.exception;

import org.springframework.http.HttpStatus;


public class EccezioneUnauthorized extends EccezioneGlobale {

	private static final long serialVersionUID = 1L;

	
	public EccezioneUnauthorized(String message) {
        super(HttpStatus.UNAUTHORIZED, message);
    }
}
