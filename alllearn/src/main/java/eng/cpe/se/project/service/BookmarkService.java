package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.Bookmark;
import eng.cpe.se.project.repository.BookmarkRepository;

@Service
public class BookmarkService {
	@Autowired
	private BookmarkRepository bookmarkRepository;
	
	public void save(Bookmark bookmark) {
		bookmarkRepository.save(bookmark);
	}
	
	public List<Bookmark> findAll(){
		return (List<Bookmark>) bookmarkRepository.findAll();
	}
	
	public Bookmark findById(int id) {
		return bookmarkRepository.findById(id).get();
	}
	
	public void delete(int id) {
		bookmarkRepository.deleteById(id);
	}
}
