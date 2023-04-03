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
	
	@Query("from ContentType ct where ct.posts = :post")
	public ContentType findByPost(@Param("post")Post post);
	
	@Query("from ContentType ct where ct.courses = :course")
	public ContentType findByCourse(@Param("course")Course course);
}
