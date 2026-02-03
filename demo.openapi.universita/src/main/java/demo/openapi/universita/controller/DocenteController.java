package demo.openapi.universita.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import demo.openapi.universita.controller.generated.DocentiApi;
import demo.openapi.universita.model.Docente;
import demo.openapi.universita.model.DocenteCreate;
import demo.openapi.universita.service.DocenteService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.constraints.NotNull;


@RestController
public class DocenteController implements DocentiApi {

	@Autowired
	private DocenteService docenteService;

	
	@Override
	public ResponseEntity<Docente> creaDocente(@RequestBody DocenteCreate docente) {

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(docenteService.creaDocente(docente));
	}

	@Override
	public ResponseEntity<List<Docente>> listaDocenti() {

		return ResponseEntity
				.status(HttpStatus.OK)
				.body(docenteService.dammiTuttiIDocenti());
	}

	@Override
	public ResponseEntity<Docente> cercaDocente(@PathVariable Integer id) {

		return ResponseEntity
				.status(HttpStatus.OK)
				.body(docenteService.dammiDocenteDaId(id));
	}

	@Override
	public ResponseEntity<Docente> aggiornaDocente(@PathVariable Integer id, @RequestBody Docente docente) {

		return ResponseEntity
				.status(HttpStatus.OK)
				.body(docenteService.modificaDocente(id, docente));
	}

	@Override
	public ResponseEntity<Void> cancellaDocente(@NotNull Integer id) {

		docenteService.cancellaDocente(id);

		return ResponseEntity
				.noContent()
				.build();
	}

}
