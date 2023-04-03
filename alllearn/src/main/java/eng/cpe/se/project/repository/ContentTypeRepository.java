package eng.cpe.se.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.ContentType;
import eng.cpe.se.project.model.Course;
import eng.cpe.se.project.model.Post;

@Repository
public interface ContentTypeRepository extends CrudRepository<ContentType, Integer> {
	
	@Query("select p.contentType from Post p where p = :post")
	public ContentType findByPost(@Param("post")Post post);
	
	@Query("select c.contentType from Course c where c = :course")
	public ContentType findByCourse(@Param("course")Course course);
}
