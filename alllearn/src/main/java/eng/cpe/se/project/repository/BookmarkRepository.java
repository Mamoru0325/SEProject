package eng.cpe.se.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.Bookmark;

@Repository
public interface BookmarkRepository extends CrudRepository<Bookmark, Integer> {
	
}
