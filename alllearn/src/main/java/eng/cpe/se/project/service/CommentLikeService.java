package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.CommentLike;
import eng.cpe.se.project.repository.CommentLikeRepository;

@Service
public class CommentLikeService {
	@Autowired
	private CommentLikeRepository commentLikeRepository;
	
	public void save(CommentLike commentLike) {
		commentLikeRepository.save(commentLike);
	}
	
	public List<CommentLike> findAll(){
		return (List<CommentLike>) commentLikeRepository.findAll();
	}
	
	public CommentLike findById(int id) {
		return commentLikeRepository.findById(id).get();
	}
	
	public void delete(int id) {
		commentLikeRepository.deleteById(id);
	}
	
}
