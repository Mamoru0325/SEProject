package eng.cpe.se.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.ImgPost;
import eng.cpe.se.project.model.Post;

@Repository
public interface ImgPostRepository extends CrudRepository<ImgPost, Integer> {
	@Query("from ImgPost ip where ip.post = :post")
	public ImgPost findByPost(@Param("post")Post post);
	
	@Query("select ip from ImgPost ip where ip.post p where p.reportStatus = 'Done' order by p.createDate desc")
	public List<ImgPost> findAllByPostDate();
}
