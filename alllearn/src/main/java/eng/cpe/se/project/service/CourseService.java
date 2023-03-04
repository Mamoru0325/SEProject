package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.Course;
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

}
