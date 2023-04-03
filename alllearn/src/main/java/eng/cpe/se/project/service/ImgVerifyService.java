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
import eng.cpe.se.project.model.ImgComment;
import eng.cpe.se.project.model.ImgVerify;
import eng.cpe.se.project.model.RequestVerify;
import eng.cpe.se.project.repository.ImgVerifyRepository;

@Service
public class ImgVerifyService {

	@Value("${external.resoures.path}")
	private String externalPath;
	@Autowired
	private ImgVerifyRepository imgVerifyRepository;

	public void save(ImgVerify imgVerify) {
		imgVerifyRepository.save(imgVerify);
	}

	public List<ImgVerify> findAll() {
		return (List<ImgVerify>) imgVerifyRepository.findAll();
	}

	public ImgVerify findById(int id) {
		return imgVerifyRepository.findById(id).get();
	}

	public void delete(int id) {
		imgVerifyRepository.deleteById(id);
	}

	public void init() {
		// TODO Auto-generated method stub
		File folder = new File(externalPath + File.separator + "Verify" + File.separator);
		if (!folder.exists()) {
			folder.mkdirs();
		}
	}

	public Resource load(String filename) {
		// TODO Auto-generated method stub
		try {
			File file = new File(externalPath + File.separator + "Verify" + File.separator);
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

	public void saveimg(MultipartFile file, RequestVerify requestVerify) throws IOException {

		File folder = new File(externalPath + File.separator + "Verify" + File.separator + "requestVerifyId"
				+ requestVerify.getRequestVerifyId());
		if (!folder.exists()) {
			folder.mkdirs();
		}
		String filename = externalPath + File.separator + "Verify" + File.separator + "requestVerifyId"
				+ requestVerify.getRequestVerifyId() + File.separator + 1;
		String change = "..";
		String type = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
		filename = filename + "." + type;

		OutputStream outputStream = new FileOutputStream(filename);
		outputStream.write(file.getBytes());
		outputStream.close();
		filename = filename.substring(externalPath.length());
		filename = change + filename;
		System.out.println(filename);
		ImgVerify img = new ImgVerify(requestVerify, filename);
		save(img);
	}
	
	public ImgVerify findByRequestVerify(RequestVerify verify) {
		return imgVerifyRepository.findByRequestVerify(verify);
	}
}
