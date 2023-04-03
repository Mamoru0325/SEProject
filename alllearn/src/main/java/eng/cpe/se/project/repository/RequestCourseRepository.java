package eng.cpe.se.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.RequestCourse;
import eng.cpe.se.project.model.User;

@Repository
public interface RequestCourseRepository extends CrudRepository<RequestCourse, Integer> {
	@Query("from RequestCourse rc where rc.user = :user")
	public List<RequestCourse> findByUser (@Param("user")User user);
}
