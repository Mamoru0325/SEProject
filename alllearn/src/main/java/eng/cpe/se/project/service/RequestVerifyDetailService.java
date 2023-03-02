package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.RequestVerifyDetail;
import eng.cpe.se.project.repository.RequestVerifyDetailRepository;

@Service
public class RequestVerifyDetailService {
	@Autowired
	private RequestVerifyDetailRepository verifyDetailRepository;
	
	public void save(RequestVerifyDetail verifyDetail) {
		verifyDetailRepository.save(verifyDetail);
	}
	
	public List<RequestVerifyDetail> findAll(){
		return (List<RequestVerifyDetail>) verifyDetailRepository.findAll();
	}
	
	public RequestVerifyDetail findById(int id) {
		return verifyDetailRepository.findById(id).get();
	}
	
	public void delete(int id) {
		verifyDetailRepository.deleteById(id);
	}
}
