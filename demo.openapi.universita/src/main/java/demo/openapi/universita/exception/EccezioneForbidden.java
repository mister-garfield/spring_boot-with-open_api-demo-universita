package demo.openapi.universita.exception;

import org.springframework.http.HttpStatus;


public class EccezioneForbidden extends EccezioneGlobale {

	private static final long serialVersionUID = 1L;

	
	public EccezioneForbidden(String message) {
        super(HttpStatus.FORBIDDEN, message);
    }
}
