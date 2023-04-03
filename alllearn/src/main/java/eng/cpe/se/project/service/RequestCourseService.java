package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import eng.cpe.se.project.model.RequestCourse;
import eng.cpe.se.project.model.User;
import eng.cpe.se.project.repository.RequestCourseRepository;

@Service
public class RequestCourseService {
	@Autowired
	private RequestCourseRepository requestCourseRepository;
	@Autowired
	private UserService userService;
	
	public void save(RequestCourse requestCourse) {
		requestCourseRepository.save(requestCourse);
	}
	
	public List<RequestCourse> findAll(){
		return (List<RequestCourse>) requestCourseRepository.findAll();
	}
	
	public RequestCourse findById(int id) {
		return requestCourseRepository.findById(id).get();
	}
	
	public void delete(int id) {
		requestCourseRepository.deleteById(id);
	}
	
	public List<RequestCourse> findByUser(User user){
		return requestCourseRepository.findByUser(user);
	}
}
