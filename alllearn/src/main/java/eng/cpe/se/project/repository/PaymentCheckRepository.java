package eng.cpe.se.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.Course;
import eng.cpe.se.project.model.PaymentCheck;
import eng.cpe.se.project.model.User;

@Repository
public interface PaymentCheckRepository extends CrudRepository<PaymentCheck, Integer> {
	@Query("select pc from PaymentCheck pc inner join pc.user u inner join pc.joinCourse jc inner join jc.course c where u.userId = :user and c.courseId = :course")
	public PaymentCheck findByUserAndCourse(@Param("user")User user,@Param("course")Course course);
}
