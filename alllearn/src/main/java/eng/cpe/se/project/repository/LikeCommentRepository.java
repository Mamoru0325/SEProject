package eng.cpe.se.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.Comment;
import eng.cpe.se.project.model.LikeComment;
import eng.cpe.se.project.model.User;

@Repository
public interface LikeCommentRepository extends CrudRepository<LikeComment, Integer> {
	@Query("select count(lc) from LikeComment lc where lc.comment = :comment")
	public int countLikeComment(@Param("comment")Comment comment);
	
	@Query("select lc from LikeComment lc where lc.comment = :comment and lc.user = :user")
	public LikeComment findByCommentAndUser(@Param("comment")Comment comment,@Param("user")User user);
}
