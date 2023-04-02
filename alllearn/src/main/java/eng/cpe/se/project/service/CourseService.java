package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.Course;
import eng.cpe.se.project.model.PaymentCheck;
import eng.cpe.se.project.model.User;
import eng.cpe.se.project.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	
	public void save(Course course) {
		courseRepository.save(course);
	}
	
	public List<Course> findAll(){
		return (List<Course>) courseRepository.findAll();
	}
	
	public Course findById(int id) {
		return courseRepository.findById(id).get();
	}
	
	public void delete(int id) {
		courseRepository.deleteById(id);
	}
	
	public List<Course> findAll(int page,int value){
		Pageable pageable = PageRequest.of(page-1, value);
		return (List<Course>) courseRepository.findAll(pageable);
	}
	
	public Course findByPayment(int id) {
		
		return courseRepository.findByPayment(id);
	}
	
	public List<Course> findAllWaitingStatus(int page,int value){
		Pageable pageable = PageRequest.of(page-1, value);
		return (List<Course>) courseRepository.findAllWaitingStatus(pageable);
	}
	
	public List<Course> findAllByUser(int page,int value,User user){
		Pageable pageable = PageRequest.of(page-1, value);
		return courseRepository.findAllByUser(pageable, user);
	}
	
	public List<Course> findAllJoinByUser(int page,int value,User user){
		Pageable pageable = PageRequest.of(page-1, value);
		return  courseRepository.findAllJoinByUser(pageable, user);
	}

}
