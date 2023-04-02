package eng.cpe.se.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.Course;
import eng.cpe.se.project.model.PaymentCheck;

@Repository
public interface PaymentCheckRepository extends CrudRepository<PaymentCheck, Integer> {
	@Query("select pc from JoinCourse jc inner join jc.paymentChecks pc inner join pc.user u where jc.course = :course and pc.status = 'Waiting' order by pc.user ASC")
	public List<PaymentCheck> findInCourseByWaitingStatus (@Param("course")Course course);
}
