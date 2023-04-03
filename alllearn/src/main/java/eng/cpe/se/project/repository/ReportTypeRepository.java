package eng.cpe.se.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.Report;
import eng.cpe.se.project.model.ReportType;

@Repository
public interface ReportTypeRepository extends CrudRepository<ReportType, Integer> {
	@Query("select r.reportType from Report r where r = :report")
	public ReportType findByReport(@Param("report")Report report);
}
