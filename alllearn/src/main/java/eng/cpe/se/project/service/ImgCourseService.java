package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.ImgCourse;
import eng.cpe.se.project.repository.ImgCourseRepository;

@Service
public class ImgCourseService {
	@Autowired
	private ImgCourseRepository imgCourseRepository;
	
	public void save(ImgCourse imgCourse) {
		imgCourseRepository.save(imgCourse);
	}
	
	public List<ImgCourse> findAll(){
		return (List<ImgCourse>) imgCourseRepository.findAll();
	}
	
	public ImgCourse findById(int id) {
		return imgCourseRepository.findById(id).get();
	}
	
	public void delete(int id) {
		imgCourseRepository.deleteById(id);
	}
}
