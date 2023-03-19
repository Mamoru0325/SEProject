package eng.cpe.se.project.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import eng.cpe.se.project.model.RequestVerify;

@Repository
public interface RequestVerifyRepository extends CrudRepository<RequestVerify, Integer> {
	@Query("from RequestVerify r")
	public List<RequestVerify>findAll(Pageable pageable);
}
