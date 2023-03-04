package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.ApproveWithdrawDetail;
import eng.cpe.se.project.repository.ApproveWithdrawDetailRepository;

@Service
public class ApproveWithdrawDetailService {
	@Autowired
	private ApproveWithdrawDetailRepository detailRepository;
	
	public void save(ApproveWithdrawDetail approveWithdrawDetail) {
		detailRepository.save(approveWithdrawDetail);
	}
	
	public List<ApproveWithdrawDetail> findAll(){
		return (List<ApproveWithdrawDetail>) detailRepository.findAll();
	}
	
	public ApproveWithdrawDetail findById(int id) {
		return detailRepository.findById(id).get();
	}
	
	public void delete(int id) {
		detailRepository.deleteById(id);
	}
}
