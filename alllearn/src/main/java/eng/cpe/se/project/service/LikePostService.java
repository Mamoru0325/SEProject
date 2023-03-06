package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.LikePost;
import eng.cpe.se.project.repository.LikePostRepository;

@Service
public class LikePostService {
	@Autowired
	private LikePostRepository likePostRepository;
	
	public void save(LikePost likePost) {
		likePostRepository.save(likePost);
	}
	
	public List<LikePost> findAll(){
		return (List<LikePost>) likePostRepository.findAll();
	}
	
	public LikePost findById(int id) {
		return likePostRepository.findById(id).get();
	}
	
	public void delete(int id) {
		likePostRepository.deleteById(id);
	}
}
