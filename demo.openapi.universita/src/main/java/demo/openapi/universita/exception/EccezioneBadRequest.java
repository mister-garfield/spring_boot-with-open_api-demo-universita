package demo.openapi.universita.exception;

import org.springframework.http.HttpStatus;


public class EccezioneBadRequest extends EccezioneGlobale {

	private static final long serialVersionUID = 1L;

	
	public EccezioneBadRequest(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
	
}
