package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.Report;
import eng.cpe.se.project.model.ReportType;
import eng.cpe.se.project.repository.ReportTypeRepository;

@Service
public class ReportTypeService {
	@Autowired
	private ReportTypeRepository reportTypeRepository;
	
	public void save(ReportType reportType) {
		reportTypeRepository.save(reportType);
	}
	
	public List<ReportType> findAll(){
		return (List<ReportType>) reportTypeRepository.findAll();
	}
	
	public ReportType findById(int id) {
		return reportTypeRepository.findById(id).get();
	}
	
	public void delete(int id) {
		reportTypeRepository.deleteById(id);
	}
	
	public ReportType findByReport(Report report) {
		return reportTypeRepository.findByReport(report);
	}
	
}
