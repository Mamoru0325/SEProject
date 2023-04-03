package eng.cpe.se.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.Course;
import eng.cpe.se.project.model.ImgCourse;

@Repository
public interface ImgCourseRepository extends CrudRepository<ImgCourse, Integer> {
	@Query("from ImgCourse ic where ic.course = :course")
	public ImgCourse findByCourse (@Param("course")Course course);
}
