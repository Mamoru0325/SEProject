package eng.cpe.se.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.ReportType;

@Repository
public interface ReportTypeRepository extends CrudRepository<ReportType, Integer> {

}
