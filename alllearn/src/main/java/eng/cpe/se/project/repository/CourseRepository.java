package eng.cpe.se.project.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
	
	@Query("from Course c")
	public List<Course> findAll(Pageable pageable);

}
