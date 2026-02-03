package demo.openapi.universita.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import demo.openapi.universita.entity.DocenteEntity;
import demo.openapi.universita.model.Docente;
import demo.openapi.universita.model.DocenteCreate;

@Mapper(componentModel = "spring")
public abstract class DocenteMapper {


//	@Mapping(target = "name", expression = "java(simpleService.enrichName(Docente.getName()))")
	public abstract Docente entityToDocente(DocenteEntity docente);

	public abstract DocenteCreate entityToDocenteCreate(DocenteEntity docente);

	public abstract List<Docente> entityToDocenteList(List<DocenteEntity> listaDocenti);

	public abstract List<DocenteCreate> entityToDocenteCreateList(List<DocenteEntity> listaDocenti);

	public abstract DocenteEntity docenteToEntity(Docente docente);

	public abstract DocenteEntity docenteCreateToEntity(DocenteCreate docente);

	public abstract List<DocenteEntity> docenteToEntityList(List<Docente> listaDocenti);

	public abstract List<DocenteEntity> docenteCreateToEntityList(List<DocenteCreate> listaDocentiCreate);

}
