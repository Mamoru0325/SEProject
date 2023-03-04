package eng.cpe.se.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.RequestVerifyDetail;

@Repository
public interface RequestVerifyDetailRepository extends CrudRepository<RequestVerifyDetail, Integer> {

}
