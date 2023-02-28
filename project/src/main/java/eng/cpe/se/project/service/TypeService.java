package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.Type;
import eng.cpe.se.project.repository.TypeRepository;

@Service
public class TypeService {
	@Autowired
	private TypeRepository typeRepository;
	
	public void save(Type type) {
		typeRepository.save(type);
	}
	
	public List<Type> findAll(){
		return (List<Type>) typeRepository.findAll();
	}
	
	public Type findById(int id) {
		return typeRepository.findById(id).get();
	}
	
	public void delete(int id) {
		typeRepository.deleteById(id);
	}
}
