package eng.cpe.se.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.ImgPost;

@Repository
public interface ImgPostRepository extends CrudRepository<ImgPost, Integer> {

}
