package demo.openapi.universita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.openapi.universita.entity.StudenteEntity;


@Repository
public interface StudenteRepository extends JpaRepository<StudenteEntity, Integer> {

}
