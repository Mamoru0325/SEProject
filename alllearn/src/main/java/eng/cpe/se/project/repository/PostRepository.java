package eng.cpe.se.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import eng.cpe.se.project.model.Post;
import eng.cpe.se.project.model.User;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
	
	@Query("from Post p")
	public List<Post> findAll(Pageable pageable);
	
	@Query("from Post p order by p.createDate desc")
	public List<Post> findAllByDate(Pageable pageable);
	
	@Query("select p from Post p inner join p.likePosts lp group by lp.post order by count(lp.post) desc")
	public List<Post> findAllByPopulation(Pageable pageable);
	
	@Query("select p FROM Post p inner join p.user u inner join u.followersForFollowTo f WHERE f.userByFollowBy= :user order by p.createDate desc")
	public List<Post> findAllByFollowerandDate(Pageable pageable,@Param("user") User user);
	
	@Query("select p from Post p inner join p.likePosts lp inner join p.user u inner join u.followersForFollowTo f WHERE f.userByFollowBy= :User group by lp.post order by count(lp.post) desc")
	public List<Post> findAllByPopulationfromFollower(Pageable pageable,@Param("User") User user);
	
}
