package eng.cpe.se.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.ImgVerify;
import eng.cpe.se.project.model.RequestVerify;

@Repository
public interface ImgVerifyRepository extends CrudRepository<ImgVerify, Integer> {
	@Query("from ImgVerify iv where iv.requestVerify = :requestVerify")
	public ImgVerify findByRequestVerify (@Param("requestVerify")RequestVerify requestVerify);
}
