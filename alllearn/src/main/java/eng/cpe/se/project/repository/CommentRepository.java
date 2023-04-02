package eng.cpe.se.project.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.Comment;
import eng.cpe.se.project.model.Post;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
	
	@Query("select c from Comment c inner join c.post p where p = :post and c.reportStatus = 'Done'")
	public List<Comment> findAllByPost(@Param("post")Post post,Pageable pageable);


}
