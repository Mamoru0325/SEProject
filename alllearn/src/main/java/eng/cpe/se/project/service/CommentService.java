package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.Comment;
import eng.cpe.se.project.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;

	public void save(Comment comment) {
		commentRepository.save(comment);
	}

	public List<Comment>findAll(){
		return (List<Comment>) commentRepository.findAll();
	}
	
	public Comment findById(int id) {
		return commentRepository.findById(id).get();
	}
	
	public void delete(int id) {
		commentRepository.deleteById(id);
	}
}
