package eng.cpe.se.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	@Query("from User u where u.email = :email")
	public User findByEmail(@Param("email")String email);
	
	@Query("from User u where u.username = :username")
	public User findByUserName(@Param("username")String username);
}
