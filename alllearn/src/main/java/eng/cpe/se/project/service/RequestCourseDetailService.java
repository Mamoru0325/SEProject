package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.RequestCourseDetail;
import eng.cpe.se.project.repository.RequestCourseDetailRepository;

@Service
public class RequestCourseDetailService {
	@Autowired
	private RequestCourseDetailRepository requestCourseDetailRepository;
	
	public void save(RequestCourseDetail requestCourseDetail) {
		requestCourseDetailRepository.save(requestCourseDetail);
	}
	
	public List<RequestCourseDetail> findAll(){
		return (List<RequestCourseDetail>) requestCourseDetailRepository.findAll();
	}
	
	public RequestCourseDetail findById(int id) {
		return requestCourseDetailRepository.findById(id).get();
	}
	
	public void delete(int id) {
		requestCourseDetailRepository.deleteById(id);
	}
}
