package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.ApproveWithdraw;
import eng.cpe.se.project.repository.ApproveWithdrawRepository;

@Service
public class ApproveWithdrawService {
	@Autowired
	private ApproveWithdrawRepository approveWithdrawRepository;
	
	public void save(ApproveWithdraw approveWithdraw) {
		approveWithdrawRepository.save(approveWithdraw);
	}
	
	public List<ApproveWithdraw> findAll(){
		return (List<ApproveWithdraw>) approveWithdrawRepository.findAll();
	}
	
	public ApproveWithdraw findById(int id) {
		return approveWithdrawRepository.findById(id).get();
	}
	
	public void delete(int id) {
		approveWithdrawRepository.deleteById(id);
	}
	
}
