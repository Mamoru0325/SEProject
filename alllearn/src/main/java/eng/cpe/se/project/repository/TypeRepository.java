package eng.cpe.se.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.Type;

@Repository
public interface TypeRepository extends CrudRepository<Type, Integer> {

}
