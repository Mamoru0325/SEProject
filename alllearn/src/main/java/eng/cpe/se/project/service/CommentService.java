package eng.cpe.se.project.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.Comment;
import eng.cpe.se.project.model.ImgComment;
import eng.cpe.se.project.model.Post;
import eng.cpe.se.project.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private ImgCommentService imgCommentService;

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
		Comment comment = findById(id);
		ImgComment imgComment = imgCommentService.findByComment(comment);
		File img = new File(imgComment.getImgPath());
		img.deleteOnExit();
		commentRepository.deleteById(id);
	}
	
	public List<Comment>findAllByPost(Post post,int page,int value){
		Pageable pageable = PageRequest.of(page-1, value);
		return commentRepository.findAllByPost(post, pageable);
	}
	
	
}
