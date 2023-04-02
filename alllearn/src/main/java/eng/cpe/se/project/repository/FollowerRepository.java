package eng.cpe.se.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.Follower;
import eng.cpe.se.project.model.User;

@Repository
public interface FollowerRepository extends CrudRepository<Follower, Integer> {
	@Query("select count(f.userByFollowBy) from Follower f where f.userByFollowTo = :user")
	public int countFollower(@Param("user")User user);
}
