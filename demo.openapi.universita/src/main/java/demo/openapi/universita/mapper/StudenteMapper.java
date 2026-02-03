package demo.openapi.universita.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import demo.openapi.universita.entity.StudenteEntity;
import demo.openapi.universita.model.Studente;
import demo.openapi.universita.model.StudenteCreate;

@Mapper(componentModel = "spring")
public abstract class StudenteMapper {

	
	public abstract Studente entityToStudente(StudenteEntity studente);

	public abstract StudenteCreate entityToStudenteCreate(StudenteEntity studente);

	public abstract List<Studente> entityToStudenteList(List<StudenteEntity> listaStudenti);

	public abstract List<StudenteCreate> entityToStudenteCreateList(List<StudenteEntity> listaStudenti);

	public abstract StudenteEntity studenteToEntity(Studente studente);

	public abstract StudenteEntity studenteCreateToEntity(StudenteCreate studente);

	public abstract List<StudenteEntity> studenteToEntityList(List<Studente> listaStudenti);

	public abstract List<StudenteEntity> studenteCreateToEntityList(List<StudenteCreate> listaStudentiCreate);

}
