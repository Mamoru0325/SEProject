package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.Report;
import eng.cpe.se.project.model.RequestVerify;
import eng.cpe.se.project.repository.ReportRepository;

@Service
public class ReportService {
	@Autowired
	private ReportRepository reportRepository;
	
	public void save(Report report) {
		reportRepository.save(report);
	}
	
	public List<Report> findAll(){
		return (List<Report>) reportRepository.findAll();
	}
	
	public Report findById(int id) {
		return reportRepository.findById(id).get();
	}
	
	public void delete(int id) {
		reportRepository.deleteById(id);
	}
	public List<Report> findAll(int page,int value){
		Pageable pageable = PageRequest.of(page, value);
		return (List<Report>) reportRepository.findAll(pageable);
	}
}
