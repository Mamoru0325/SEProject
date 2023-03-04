package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.PaymentCheck;
import eng.cpe.se.project.repository.PaymentCheckRepository;

@Service
public class PaymentCheckService {
	@Autowired
	private PaymentCheckRepository paymentCheckRepository;
	
	public void save(PaymentCheck paymentCheck) {
		paymentCheckRepository.save(paymentCheck);
	}
	
	public List<PaymentCheck> findAll(){
		return (List<PaymentCheck>) paymentCheckRepository.findAll();
	}
	
	public PaymentCheck findById(int id) {
		return paymentCheckRepository.findById(id).get();
	}
	
	public void delete(int id) {
		paymentCheckRepository.deleteById(id);
	}
}
