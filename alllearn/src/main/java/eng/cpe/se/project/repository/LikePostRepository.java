package eng.cpe.se.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.LikePost;
import eng.cpe.se.project.model.Post;
import eng.cpe.se.project.model.User;

@Repository
public interface LikePostRepository extends CrudRepository<LikePost, Integer> {
	@Query("select count(lp) from LikePost lp where lp.post = :post")
	public int countLikePost(@Param("post")Post post);
	
	@Query("select lp from LikePost lp where lp.post = :post and lp.user = :user")
	public LikePost findByPostAndUser(@Param("post")Post post,@Param("user")User user);
}
	