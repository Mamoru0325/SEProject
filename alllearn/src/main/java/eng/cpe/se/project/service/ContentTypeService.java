package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.ContentType;
import eng.cpe.se.project.repository.ContentTypeRepository;

@Service
public class ContentTypeService {
	@Autowired
	private ContentTypeRepository contentTypeRepository;
	
	public void save(ContentType contentType) {
		contentTypeRepository.save(contentType);
	}
	
	public List<ContentType> findAll(){
		return (List<ContentType>) contentTypeRepository.findAll();
	}
	
	public ContentType findById(int id) {
		return contentTypeRepository.findById(id).get();
	}
	
	public void delete(int id) {
		contentTypeRepository.deleteById(id);
	}
}
