package demo.openapi.universita.exception;

import org.springframework.http.HttpStatus;

public class EccezioneNotImplemented extends EccezioneGlobale {

	private static final long serialVersionUID = 1L;

	public EccezioneNotImplemented(String message) {
        super(HttpStatus.NOT_IMPLEMENTED, message);
    }
}
