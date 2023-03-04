package eng.cpe.se.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.RequestVerify;

@Repository
public interface RequestVerifyRepository extends CrudRepository<RequestVerify, Integer> {

}
