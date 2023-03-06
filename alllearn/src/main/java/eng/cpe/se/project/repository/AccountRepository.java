package eng.cpe.se.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
	
	@Query("from Account a where a.firstName = :firstName")
	public Account findByName(@Param("firstName")String firstName);
	
	@Query("from Account a where a.email = :email")
	public Account findByEmail(@Param("email")String email);
	
}
