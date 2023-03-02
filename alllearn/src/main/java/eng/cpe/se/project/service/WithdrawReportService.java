package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.WithdrawReport;
import eng.cpe.se.project.repository.WithdrawReportRepository;

@Service
public class WithdrawReportService {
	@Autowired
	private WithdrawReportRepository withdrawReportRepository;
	
	public void save(WithdrawReport withdrawReport) {
		withdrawReportRepository.save(withdrawReport);
	}
	
	public List<WithdrawReport> findAll(){
		return (List<WithdrawReport>) withdrawReportRepository.findAll();
	}
	
	public WithdrawReport findById(int id) {
		return withdrawReportRepository.findById(id).get();
	}
	
	public void delete(int id) {
		withdrawReportRepository.deleteById(id);
	}
}
