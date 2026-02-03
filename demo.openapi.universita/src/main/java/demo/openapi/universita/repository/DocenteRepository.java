package demo.openapi.universita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.openapi.universita.entity.DocenteEntity;


@Repository
public interface DocenteRepository extends JpaRepository<DocenteEntity, Integer> {

}
