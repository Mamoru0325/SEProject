package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.ImgPost;
import eng.cpe.se.project.repository.ImgPostRepository;

@Service
public class ImgPostService {
	@Autowired
	private ImgPostRepository imgPostRepository;
	
	public void save(ImgPost imgPost) {
		imgPostRepository.save(imgPost);
	}
	
	public List<ImgPost> findAll(){
		return (List<ImgPost>) imgPostRepository.findAll();
	}
	
	public ImgPost findById(int id) {
		return imgPostRepository.findById(id).get();
	}
	
	public void delete(int id) {
		imgPostRepository.deleteById(id);
	}
}
