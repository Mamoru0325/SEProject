package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.ImgVerify;
import eng.cpe.se.project.repository.ImgVerifyRepository;

@Service
public class ImgVerifyService {
	@Autowired
	private ImgVerifyRepository imgVerifyRepository;
	
	public void save(ImgVerify imgVerify) {
		imgVerifyRepository.save(imgVerify);
	}
	
	public List<ImgVerify> findAll(){
		return (List<ImgVerify>) imgVerifyRepository.findAll();
	}
	
	public ImgVerify findById(int id) {
		return imgVerifyRepository.findById(id).get();
	}
	
	public void delete(int id) {
		imgVerifyRepository.deleteById(id);
	}
}
