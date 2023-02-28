package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.PostLike;
import eng.cpe.se.project.repository.PostLikeRepository;

@Service
public class PostLikeService {
	@Autowired
	private PostLikeRepository postLikeRepository;
	
	public void save(PostLike postLike) {
		postLikeRepository.save(postLike);
	}
	
	public List<PostLike> findAll(){
		return (List<PostLike>) postLikeRepository.findAll();
	}
	
	public PostLike findById(int id) {
		return postLikeRepository.findById(id).get();
	}
	
	public void delete(int id) {
		postLikeRepository.deleteById(id);
	}
}
