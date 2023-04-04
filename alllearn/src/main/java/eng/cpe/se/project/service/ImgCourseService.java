package eng.cpe.se.project.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import eng.cpe.se.project.model.Course;
import eng.cpe.se.project.model.ImgCourse;
import eng.cpe.se.project.model.ImgPost;
import eng.cpe.se.project.model.Post;
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

	public List<ImgCourse> findAll() {
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
		File folder = new File(externalPath + File.separator + "Course" + File.separator);
		if (!folder.exists()) {
			folder.mkdirs();
		}
	}

	public Resource load(String filename) {
		// TODO Auto-generated method stub
		try {
			File file = new File(externalPath + File.separator + "Course" + File.separator);
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

	public void saveimg(MultipartFile file, Course course) throws IOException {

		File folder = new File(externalPath + File.separator + "Course" + File.separator + "courseId" + course.getCourseId());
		if (!folder.exists()) {
			folder.mkdirs();
		}
		String filename = externalPath + File.separator + "course" + File.separator + "courseId" + course.getCourseId()
				+ File.separator + 1;
		String change = "..";
		String type = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
		filename = filename + "." + type;

		OutputStream outputStream = new FileOutputStream(filename);
		outputStream.write(file.getBytes());
		outputStream.close();
		filename = filename.substring(externalPath.length());
		filename = change + filename;
		System.out.println(filename);
		ImgCourse img = new ImgCourse(course, filename);
		save(img);
	}
	
	public ImgCourse findByCourse(Course course) {
		return imgCourseRepository.findByCourse(course);
	}
}
