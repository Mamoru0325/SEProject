package eng.cpe.se.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.CourseCreator;

@Repository
public interface CourseCreatorRepository extends CrudRepository<CourseCreator, Integer> {

}
