package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.Course;
import eng.cpe.se.project.model.JoinCourse;
import eng.cpe.se.project.repository.JoinCourseRepository;


@Service
public class JoinCourseService {
	@Autowired
	private JoinCourseRepository joinCourseRepository;
	@Autowired
	private CourseService courseService;
	
	public void save(JoinCourse joinCourse) {
		joinCourseRepository.save(joinCourse);
	}
	
	public List<JoinCourse> findAll(){
		return (List<JoinCourse>) joinCourseRepository.findAll();
	}
	
	public JoinCourse findById(int id) {
		return joinCourseRepository.findById(id).get();
	}
	
	public void delete(int id) {
		joinCourseRepository.deleteById(id);
	}
	
}
