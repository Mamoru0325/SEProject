package eng.cpe.se.project.service;

import java.io.File;
import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.ImgPost;
import eng.cpe.se.project.repository.ImgPostRepository;

@Service
public class ImgPostService {
	
	@Value("${external.resoures.path}")
	private String externalPath;
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
	
	public void init() {
		// TODO Auto-generated method stub
		File folder = new File(externalPath+File.separator+"Post"+File.separator);
		if (!folder.exists()) {
			folder.mkdirs();
		}
	}
	
	public Resource load(String filename) {
		// TODO Auto-generated method stub
		try {
			File file = new File(externalPath+File.separator+"Post"+File.separator);
		      Resource resource = new UrlResource(file.toURI());

		      if (resource.exists() || resource.isReadable()) {
		        return resource;
		      } else {
		        throw new RuntimeException("Could not read the file!");
		      }
		    } catch (MalformedURLException e) {
		      throw new RuntimeException("Error: " + e.getMessage());
		    }
	}
}
