package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.RequestVerify;
import eng.cpe.se.project.repository.RequestVerifyRepository;

@Service
public class RequestVerifyService {
	@Autowired
	private RequestVerifyRepository requestVerifyRepository;
	
	public void save(RequestVerify requestVerify) {
		requestVerifyRepository.save(requestVerify);
	}
	
	public List<RequestVerify> findAll(){
		return (List<RequestVerify>) requestVerifyRepository.findAll();
	}
	
	public RequestVerify findById(int id) {
		return requestVerifyRepository.findById(id).get();
	}
	
	public void delete(int id) {
		requestVerifyRepository.deleteById(id);
	}
	public List<RequestVerify> findAll(int page,int value){
		Pageable pageable = PageRequest.of(page, value);
		return (List<RequestVerify>) requestVerifyRepository.findAll(pageable);
	}
}
