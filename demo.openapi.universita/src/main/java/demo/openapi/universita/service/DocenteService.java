package demo.openapi.universita.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.openapi.universita.entity.DocenteEntity;
import demo.openapi.universita.exception.EccezioneNotFound;
import demo.openapi.universita.mapper.DocenteMapper;
import demo.openapi.universita.model.Docente;
import demo.openapi.universita.model.DocenteCreate;
import demo.openapi.universita.repository.DocenteRepository;


@Service
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;
    
    @Autowired
    private DocenteMapper docenteMapper;

    
    public Docente creaDocente(DocenteCreate docenteInput) {
    	
    	DocenteEntity docenteSalvato = docenteRepository
    			.save(docenteMapper.docenteCreateToEntity(docenteInput));
    	
        return docenteMapper.entityToDocente(docenteSalvato);
    }
    
    public List<Docente> dammiTuttiIDocenti() {
        return docenteMapper.entityToDocenteList(docenteRepository.findAll());
    }

    public Docente dammiDocenteDaId(Integer id) {
    	
    	Optional<DocenteEntity> docenteOptional = docenteRepository.findById(id);
        if (docenteOptional.isEmpty()) {
        	throw new EccezioneNotFound("Nessun Dipendente presente con questo id: " + id);
        }
        
        return docenteMapper.entityToDocente(docenteOptional.get());
    }

    public Docente modificaDocente(Integer id, Docente docenteInput) {
    	
        Optional<DocenteEntity> docenteOptional = docenteRepository.findById(id);
        if (docenteOptional.isEmpty()) {
        	throw new EccezioneNotFound("Nessun Dipendente presente con questo id: " + id);
        }
        
        DocenteEntity docenteDaModificare = docenteOptional.get();
        docenteDaModificare = docenteMapper.docenteToEntity(docenteInput);
//        docenteDaModificare.setId(id);
//        docenteDaModificare.setNome(docenteInput.getNome());
//        docenteDaModificare.setCognome(docenteInput.getCognome());
//        docenteDaModificare.setCodiceFiscale(docenteInput.getCodiceFiscale());
//        docenteDaModificare.setSesso(docenteInput.getSesso());
//        docenteDaModificare.setMatricola(docenteInput.getMatricola());
//        docenteDaModificare.setAnzianita(docenteInput.getAnzianita());
        
        DocenteEntity docenteAggiornato = docenteRepository.save(docenteDaModificare);
        
        return docenteMapper.entityToDocente(docenteAggiornato);
    }

    public void cancellaDocente(Integer id) {
    	
        if (docenteRepository.existsById(id)) {
        	 throw new EccezioneNotFound("Nessun Dipendente presente con questo id: " + id);
        }
        
        docenteRepository.deleteById(id);
    }

}
