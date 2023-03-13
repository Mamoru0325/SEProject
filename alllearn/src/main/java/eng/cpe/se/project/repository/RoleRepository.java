package eng.cpe.se.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
	@Query("from Role r where r.roleName = :roleName")
	public Role findByRoleName(@Param("roleName")String roleName);
}
