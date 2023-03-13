package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.Follower;
import eng.cpe.se.project.model.PaymentCheck;
import eng.cpe.se.project.repository.PaymentCheckRepository;

@Service
public class PaymentCheckService {
	@Autowired
	private PaymentCheckRepository checkRepository;
	
	public void save(PaymentCheck paymentCheck) {
		checkRepository.save(paymentCheck);
	}
	
	public List<PaymentCheck> findAll(){
		return (List<PaymentCheck>) checkRepository.findAll();
	}
	
	public PaymentCheck findById(int id) {
		return checkRepository.findById(id).get();
	}
	
	public void delete(int id) {
		checkRepository.deleteById(id);
	}
}
