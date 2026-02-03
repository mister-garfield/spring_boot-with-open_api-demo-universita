package demo.openapi.universita.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.openapi.universita.entity.StudenteEntity;
import demo.openapi.universita.exception.EccezioneNotFound;
import demo.openapi.universita.mapper.StudenteMapper;
import demo.openapi.universita.model.Studente;
import demo.openapi.universita.model.StudenteCreate;
import demo.openapi.universita.repository.StudenteRepository;



@Service
public class StudenteService {

    @Autowired
    private StudenteRepository studenteRepository;
    
    @Autowired
    private StudenteMapper studenteMapper;

    
    public Studente creaStudente(StudenteCreate studenteInput) {
    	
    	StudenteEntity studenteSalvato = studenteRepository
    			.save(studenteMapper.studenteCreateToEntity(studenteInput));
    	
        return studenteMapper.entityToStudente(studenteSalvato);
    }
    
    public List<Studente> dammiTuttiGliStudenti() {
    	
        return studenteMapper.entityToStudenteList(studenteRepository.findAll());
        
    }
    
    public Studente dammiStudenteDaId(Integer id) {
    	
    	Optional<StudenteEntity> studentepresente = studenteRepository.findById(id);
    	
    	if (studentepresente.isEmpty()) {
    		throw new EccezioneNotFound("Nessuno studente presente con questo id: " + id);
    	}
    	
    	return studenteMapper.entityToStudente(studentepresente.get());
    }

    public Studente modificaStudente(Integer id, Studente studenteInput) {
    	
        Optional<StudenteEntity> studenteOptional = studenteRepository.findById(id);
        if (!studenteOptional.isPresent()) {
        	 throw new EccezioneNotFound("Nessuno studente presente con questo id: " + id);
        }
        
        StudenteEntity studenteDaModificare = studenteOptional.get();
        studenteDaModificare = studenteMapper.studenteToEntity(studenteInput);
//        studenteDaModificare.setId(id);
//        studenteDaModificare.setNome(studenteInput.getNome());
//        studenteDaModificare.setCognome(studenteInput.getCognome());
//        studenteDaModificare.setCodiceFiscale(studenteInput.getCodiceFiscale());
//        studenteDaModificare.setSesso(studenteInput.getSesso());
//        studenteDaModificare.setMatricola(studenteInput.getMatricola());
//        studenteDaModificare.setCorsoDiLaurea(studenteInput.getCorsoDiLaurea());
        
        StudenteEntity studenteAggiornato = studenteRepository.save(studenteDaModificare);
        
        return studenteMapper.entityToStudente(studenteAggiornato);
    }

    public void cancellaStudente(Integer id) {
    	
        if (!studenteRepository.existsById(id)) {
            throw new EccezioneNotFound("Nessuno studente presente con questo id: " + id);
        }
        
        studenteRepository.deleteById(id);
    }

}
