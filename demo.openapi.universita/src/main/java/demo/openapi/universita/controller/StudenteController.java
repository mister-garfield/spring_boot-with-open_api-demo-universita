package demo.openapi.universita.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import demo.openapi.universita.controller.generated.StudentiApi;
import demo.openapi.universita.model.Studente;
import demo.openapi.universita.model.StudenteCreate;
import demo.openapi.universita.service.StudenteService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.constraints.NotNull;


@RestController
public class StudenteController implements StudentiApi {
	
	@Autowired
    private StudenteService studenteService;

	
	@Override
    public ResponseEntity<Studente> creaStudente(
    		@RequestBody StudenteCreate studente) {
		
		return ResponseEntity
	 		.status(HttpStatus.CREATED)
	 		.body( studenteService.creaStudente(studente));
    }

	@Override
    public ResponseEntity<List<Studente>> listaStudenti() {
		
    	return ResponseEntity
    			.status(HttpStatus.OK)
        		.body(studenteService.dammiTuttiGliStudenti());
    }

	@Override
    public ResponseEntity<Studente> cercaStudente(
    		@PathVariable Integer id) {
		
    	return ResponseEntity
    			.status(HttpStatus.OK)
    			.body(studenteService.dammiStudenteDaId(id));
    }

	@Override
    public ResponseEntity<Studente> aggiornaStudente(
    		@PathVariable Integer id, 
    		@RequestBody Studente studente) {
		
    	Studente studenteModificato = studenteService.modificaStudente(id, studente);
		
    	return ResponseEntity
                .status(HttpStatus.OK)
                .body(studenteModificato);
    }

	@Override
	public ResponseEntity<Void> cancellaStudente(
			@NotNull Integer id) {
		
    	studenteService.cancellaStudente(id);
    	
    	return ResponseEntity.noContent().build();
	}

}
