package eng.cpe.se.project.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.Course;
import eng.cpe.se.project.model.PaymentCheck;
import eng.cpe.se.project.model.User;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
	
	@Query("from Course c where c.reportStatus = 'Done'")
	public List<Course> findAll(Pageable pageable);
	
	@Query("select c from PaymentCheck pc inner join pc.joinCourse jc inner join jc.course c where pc.paymentCheckId = :payment")
	public Course findByPayment(@Param("payment")int payment);
	
	@Query("from Course c where c.reportStatus = 'Waiting'")
	public List<Course> findAllWaitingStatus(Pageable pageable);
	
	@Query("select c from Course c WHERE c.user = :user and c.reportStatus = 'Done' ")
	public List<Course> findAllByUser(Pageable pageable,@Param("user") User user);
	
	@Query("select c FROM Course c inner join c.joinCourses j inner join j.paymentChecks jp WHERE jp.user = :user and c.reportStatus = 'Done' group by c ")
	public List<Course> findAllJoinByUser(Pageable pageable,@Param("user") User user);

}
