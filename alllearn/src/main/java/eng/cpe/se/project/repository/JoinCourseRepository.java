package eng.cpe.se.project.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.Course;
import eng.cpe.se.project.model.JoinCourse;
import eng.cpe.se.project.model.Post;
import eng.cpe.se.project.model.User;

@Repository
public interface JoinCourseRepository extends CrudRepository<JoinCourse, Integer> {
	
}
