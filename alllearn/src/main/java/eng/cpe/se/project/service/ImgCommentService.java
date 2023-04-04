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

import eng.cpe.se.project.model.Comment;
import eng.cpe.se.project.model.Course;
import eng.cpe.se.project.model.ImgComment;
import eng.cpe.se.project.model.ImgCourse;
import eng.cpe.se.project.repository.ImgCommentRepository;

@Service
public class ImgCommentService {

	@Value("${external.resoures.path}")
	private String externalPath;
	@Autowired
	private ImgCommentRepository imgCommentRepository;

	public void save(ImgComment imgComment) {
		imgCommentRepository.save(imgComment);
	}

	public List<ImgComment> findAll() {
		return (List<ImgComment>) imgCommentRepository.findAll();
	}

	public ImgComment findById(int id) {
		return imgCommentRepository.findById(id).get();
	}

	public void delete(int id) {
		imgCommentRepository.deleteById(id);
	}

	public void init() {
		// TODO Auto-generated method stub
		File folder = new File(externalPath + File.separator + "Comment" + File.separator);
		if (!folder.exists()) {
			folder.mkdirs();
		}
	}

	public Resource load(String filename) {
		// TODO Auto-generated method stub
		try {
			File file = new File(externalPath + File.separator + "Comment" + File.separator);
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

	public void saveimg(MultipartFile file, Comment comment) throws IOException {

		File folder = new File(
				externalPath + File.separator + "Comment" + File.separator + "commentId" + comment.getCommentId());
		if (!folder.exists()) {
			folder.mkdirs();
		}
		String filename = externalPath + File.separator + "Comment" + File.separator + "commentId" + comment.getCommentId()
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
		ImgComment img = new ImgComment(comment, filename);
		save(img);
	}
	
	public ImgComment findByComment(Comment comment) {
		return imgCommentRepository.findByComment(comment);
	}
}
