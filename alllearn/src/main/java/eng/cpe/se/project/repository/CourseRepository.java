package eng.cpe.se.project.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.Course;
import eng.cpe.se.project.model.Post;
import eng.cpe.se.project.model.User;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
	
	@Query("from Course c")
	public List<Course> findAll(Pageable pageable);
	
	@Query("select c from Course c WHERE c.user = :user ")
	public List<Course> findAllByUser(Pageable pageable,@Param("user") User user);
	
	@Query("select c FROM Course c inner join c.joinCourses j inner join j.paymentChecks jp WHERE jp.user = :user group by c ")
	public List<Course> findAllJoinByUser(Pageable pageable,@Param("user") User user);
}
