package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.ImgComment;
import eng.cpe.se.project.repository.ImgCommentRepository;

@Service
public class ImgCommentService {
	@Autowired
	private ImgCommentRepository imgCommentRepository;
	
	public void save(ImgComment imgComment) {
		imgCommentRepository.save(imgComment);
	}
	
	public List<ImgComment> findAll(){
		return (List<ImgComment>) imgCommentRepository.findAll();
	}
	
	public ImgComment findById(int id) {
		return imgCommentRepository.findById(id).get();
	}
	
	public void delete(int id) {
		imgCommentRepository.deleteById(id);
	}
}
