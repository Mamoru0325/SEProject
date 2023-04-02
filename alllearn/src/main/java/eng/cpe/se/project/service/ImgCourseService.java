package eng.cpe.se.project.service;

import java.io.File;
import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.ImgCourse;
import eng.cpe.se.project.repository.ImgCourseRepository;

@Service
public class ImgCourseService {
	
	@Value("${external.resoures.path}")
	private String externalPath;
	@Autowired
	private ImgCourseRepository imgCourseRepository;
	
	public void save(ImgCourse imgCourse) {
		imgCourseRepository.save(imgCourse);
	}
	
	public List<ImgCourse> findAll(){
		return (List<ImgCourse>) imgCourseRepository.findAll();
	}
	
	public ImgCourse findById(int id) {
		return imgCourseRepository.findById(id).get();
	}
	
	public void delete(int id) {
		imgCourseRepository.deleteById(id);
	}
	
	public void init() {
		// TODO Auto-generated method stub
		File folder = new File(externalPath+File.separator+"Course"+File.separator);
		if (!folder.exists()) {
			folder.mkdirs();
		}
	}
	
	public Resource load(String filename) {
		// TODO Auto-generated method stub
		try {
			File file = new File(externalPath+File.separator+"Course"+File.separator);
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
