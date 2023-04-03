package eng.cpe.se.project.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.Comment;
import eng.cpe.se.project.model.ImgComment;

@Repository
public interface ImgCommentRepository extends CrudRepository<ImgComment, Integer> {
	@Query("from ImgComment ic where ic.comment = comment")
	public ImgComment findByComment(@Param("comment")Comment comment);
}
