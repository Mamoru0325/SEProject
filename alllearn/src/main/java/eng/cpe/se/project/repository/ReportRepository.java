package eng.cpe.se.project.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.Report;
import eng.cpe.se.project.model.RequestVerify;

@Repository
public interface ReportRepository extends CrudRepository<Report, Integer> {
	@Query("from Report re where re.status = 'Waiting'")
	public List<Report>findAll(Pageable pageable);
}
