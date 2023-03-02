package eng.cpe.se.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.CommentLike;

@Repository
public interface CommentLikeRepository extends CrudRepository<CommentLike, Integer> {

}
