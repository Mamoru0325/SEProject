package eng.cpe.se.project.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService{
	
	@Value("${external.resoures.path}")
	private String externalPath;
	private final Path path = Paths.get("/image");

	public void init() {
		// TODO Auto-generated method stub
		try {
		      Files.createDirectories(path);
		    } catch (IOException e) {
		      throw new RuntimeException("Could not initialize folder for upload!");
		    }
	}

	public void save(MultipartFile file) {
		// TODO Auto-generated method stub
		
	}

	public Resource load(String filename) {
		// TODO Auto-generated method stub
		try {
		      Path file = path.resolve(filename);
		      Resource resource = new UrlResource(file.toUri());

		      if (resource.exists() || resource.isReadable()) {
		        return resource;
		      } else {
		        throw new RuntimeException("Could not read the file!");
		      }
		    } catch (MalformedURLException e) {
		      throw new RuntimeException("Error: " + e.getMessage());
		    }
	}

	public boolean delete(String filename) {
		// TODO Auto-generated method stub
		return false;
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public Stream<Path> loadAll() {
		// TODO Auto-generated method stub
		 try {
		      return Files.walk(this.path, 1).filter(path -> !path.equals(this.path)).map(this.path::relativize);
		    } catch (IOException e) {
		      throw new RuntimeException("Could not load the files!");
		    }
	}

}
