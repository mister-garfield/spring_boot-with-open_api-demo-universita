package demo.openapi.universita.exception;

import java.nio.file.AccessDeniedException;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.TransactionException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import demo.openapi.universita.model.ErroreImprevisto;
import jakarta.validation.ConstraintViolationException;


@RestControllerAdvice
public class GestioneEccezioniGlobale {

	
    // ================== ECCEZIONI CUSTOM (gestisce tutte le tue eccezioni) ==================
    
	// EccezioneGlobale viene prima di tutte quante le altre sotto in quanto più specifica (le sue implementazioni)
    @ExceptionHandler(EccezioneGlobale.class)
    public ResponseEntity<ErroreImprevisto> handleEccezioneGlobale(EccezioneGlobale ex) {
    	String messaggio = ex.getMessage();
    	ErroreImprevisto errore = new ErroreImprevisto(messaggio);
        errore.setDettaglio(ex.getStackTrace().toString());
        return ResponseEntity.status(ex.getStatus()).body(errore);
    }

    
    // ================== VALIDAZIONE (400 Bad Request) ==================
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroreImprevisto> handleValidation(MethodArgumentNotValidException ex) {
        String messaggio = "Input non valido" + ex.getBindingResult().getFieldErrors().stream()
            .map(err -> err.getField() + ": " + err.getDefaultMessage())
            .collect(Collectors.joining(", "));
        
        ErroreImprevisto errore = new ErroreImprevisto(messaggio);
        errore.setDettaglio(ex.getStackTrace().toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errore);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErroreImprevisto> handleConstraintViolation(ConstraintViolationException ex) {
        String messaggio = ex.getConstraintViolations().stream()
            .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
            .collect(Collectors.joining(", "));
        
        ErroreImprevisto errore = new ErroreImprevisto(messaggio);
        errore.setDettaglio(ex.getStackTrace().toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errore);
    }
    
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErroreImprevisto> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
		String messaggio = String.format(
				 "Parametro '%s' non valido. Valore '%s' non è del tipo richiesto", 
				 ex.getName(), ex.getValue());
        ErroreImprevisto errore = new ErroreImprevisto(messaggio);
        errore.setDettaglio(ex.getStackTrace().toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errore);
    }

    
    // ================== BAD REQUEST (400) ==================
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroreImprevisto> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
//        		"Input malformato o illegibile",
    	
    	String messaggio = ex.getMessage();
    	ErroreImprevisto errore = new ErroreImprevisto(messaggio);
    	errore.setDettaglio(ex.getStackTrace().toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errore);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErroreImprevisto> handleMissingParams(MissingServletRequestParameterException ex) {
    	String messaggio = "Parametro obbligatorio mancante: " + ex.getParameterName();
    	ErroreImprevisto errore = new ErroreImprevisto(messaggio);
    	errore.setDettaglio(ex.getStackTrace().toString());    
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errore);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErroreImprevisto> handleMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
    	String messaggio = "Metodo HTTP non supportato: " + ex.getMethod();
    	ErroreImprevisto errore = new ErroreImprevisto(messaggio);
    	errore.setDettaglio(ex.getStackTrace().toString());        
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(errore);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ErroreImprevisto> handleMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex) {
        String messaggio =  "Media type non supportato: " + ex.getContentType();
    	ErroreImprevisto errore = new ErroreImprevisto(messaggio);
    	errore.setDettaglio(ex.getStackTrace().toString());        
        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(errore);
    }

    
    // ================== AUTHORIZATION (401, 403) ==================
    
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErroreImprevisto> handleAccessDenied(AccessDeniedException ex) {
    	String messaggio =   "Accesso negato";
    	ErroreImprevisto errore = new ErroreImprevisto(messaggio);
    	errore.setDettaglio(ex.getStackTrace().toString());  
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errore);
    }

    
    // ================== NOT FOUND (404) ==================
    
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErroreImprevisto> handleNoHandlerFound(NoHandlerFoundException ex) {
    	String messaggio = "Endpoint non trovato: " + ex.getRequestURL();
    	ErroreImprevisto errore = new ErroreImprevisto(messaggio);
    	errore.setDettaglio(ex.getStackTrace().toString());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errore);
    }
    

    // ================== CONFLICT (409) ==================
    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErroreImprevisto> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        String messaggio = "Violazione vincolo database";
        if (ex.getCause() instanceof ConstraintViolationException) {
            messaggio = "Violazione vincolo: risorsa già esistente o riferimento non valido";
        }
    	ErroreImprevisto errore = new ErroreImprevisto(messaggio);
    	errore.setDettaglio(ex.getStackTrace().toString());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errore);
    }

    
    // ================== SERVER ERRORS (500) ==================
    
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErroreImprevisto> handleNullPointer(NullPointerException ex) {
    	String messaggio = "Errore interno: riferimento null non gestito";
    	ErroreImprevisto errore = new ErroreImprevisto(messaggio);
    	errore.setDettaglio(ex.getStackTrace().toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errore);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErroreImprevisto> handleIllegalArgument(IllegalArgumentException ex) {
    	String messaggio =  ex.getMessage() != null ? ex.getMessage() : "Argomento non valido";
    	ErroreImprevisto errore = new ErroreImprevisto(messaggio);
    	errore.setDettaglio(ex.getStackTrace().toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errore);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErroreImprevisto> handleIllegalState(IllegalStateException ex) {
    	String messaggio =  ex.getMessage() != null ? ex.getMessage() : "Stato dell'applicazione non valido";
    	ErroreImprevisto errore = new ErroreImprevisto(messaggio);
    	errore.setDettaglio(ex.getStackTrace().toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errore);
    }

    
    // ================== DATABASE ERRORS (503) ==================
    
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ErroreImprevisto> handleDatabaseError(DataAccessException ex) {
    	String messaggio =  "Errore di accesso al database";
    	ErroreImprevisto errore = new ErroreImprevisto(messaggio);
    	errore.setDettaglio(ex.getStackTrace().toString());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(errore);
    }

    @ExceptionHandler(TransactionException.class)
    public ResponseEntity<ErroreImprevisto> handleTransactionError(TransactionException ex) {
    	String messaggio =  "Errore nella transazione database";
    	ErroreImprevisto errore = new ErroreImprevisto(messaggio);
    	errore.setDettaglio(ex.getStackTrace().toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errore);
    }

    
    // ================== CATCH-ALL (500) ==================
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroreImprevisto> handleGenericException(Exception ex) {
    	String messaggio =  "Errore interno del server";
    	ErroreImprevisto errore = new ErroreImprevisto(messaggio);
    	errore.setDettaglio(ex.getStackTrace().toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errore);
    }
}

