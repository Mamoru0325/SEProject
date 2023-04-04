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
	
	@Query("from Post p where p.reportStatus = 'Done' order by p.createDate desc")
	public List<Post> findAllByDateAndDoneReportStatus(Pageable pageable);
	
	@Query("from Post p where p.reportStatus = 'Done' and p.user = :user order by p.createDate desc")
	public Post findByDateAndDoneReportStatus(@Param("user")User user);
	
	@Query("select p from Post p inner join p.likePosts lp where p.reportStatus = 'Done' group by lp.post order by count(lp.post) desc")
	public List<Post> findAllByPopulationAndDoneReportStatus(Pageable pageable);
	
	@Query("from Post p where p.reportStatus = 'Waiting'")
	public List<Post> findAllByWaitingReportStatus(Pageable pageable);
	
	@Query("select p FROM Post p inner join p.user u inner join u.followersForFollowTo f WHERE f.userByFollowBy= :user and p.reportStatus = 'Done' order by p.createDate desc")
	public List<Post> findAllByFollowerandDate(Pageable pageable,@Param("user") User user);
	
	@Query("select p from Post p inner join p.likePosts lp inner join p.user u inner join u.followersForFollowTo f WHERE f.userByFollowBy= :user and p.reportStatus = 'Done' group by lp.post order by count(lp.post) desc")
	public List<Post> findAllByPopulationfromFollower(Pageable pageable,@Param("user") User user);
	
}
