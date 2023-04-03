package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.ContentType;
import eng.cpe.se.project.model.Course;
import eng.cpe.se.project.model.Post;
import eng.cpe.se.project.repository.ContentTypeRepository;

@Service
public class ContentTypeService {
	@Autowired
	private ContentTypeRepository contentTypeRepository;
	@Autowired
	private PostService postService;
	@Autowired
	private CourseService courseService;
	
	public void save(ContentType contentType) {
		contentTypeRepository.save(contentType);
	}
	
	public List<ContentType> findAll(){
		return (List<ContentType>) contentTypeRepository.findAll();
	}
	
	public ContentType findById(int id) {
		return contentTypeRepository.findById(id).get();
	}
	
	public void delete(int id) {
		contentTypeRepository.deleteById(id);
	}
	
	public ContentType findByPost(int postId) {
		Post post = postService.findById(postId);
		return contentTypeRepository.findByPost(post);
	}
	
	public ContentType findByCourse(int courseId) {
		Course course = courseService.findById(courseId);
		return contentTypeRepository.findByCourse(course);
	}
}
