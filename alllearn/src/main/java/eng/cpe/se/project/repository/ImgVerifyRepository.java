package eng.cpe.se.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.ImgVerify;

@Repository
public interface ImgVerifyRepository extends CrudRepository<ImgVerify, Integer> {

}
