package eng.cpe.se.project.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.Comment;
import eng.cpe.se.project.model.Course;
import eng.cpe.se.project.model.User;
import eng.cpe.se.project.model.dto.UserPaymentDTO;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	@Query("from User u where u.email = :email")
	public User findByEmail(@Param("email")String email);
	
	@Query("from User u where u.username = :username")
	public User findByUserName(@Param("username")String username);
	
	@Query("select u from JoinCourse jc inner join jc.paymentChecks pc inner join pc.user u where jc.course = :course and pc.status = 'Waiting' order by pc.user ASC")
	public List<User> findUserInCourseByWaitingStatus(@Param("course")Course course);
	
	@Query("select u from JoinCourse jc inner join jc.paymentChecks pc inner join pc.user u where jc.course = :course and pc.status = 'Paid' order by pc.user ASC")
	public List<User> findUserInCourseByPaidStatus(@Param("course")Course course);
	
	@Query("select count(u) from JoinCourse jc inner join jc.paymentChecks pc inner join pc.user u where jc.course = :course and pc.status = 'Paid'")
	public int countUserByPaidStatus(@Param("course")Course course);
	
	@Query("select count(u) from JoinCourse jc inner join jc.paymentChecks pc inner join pc.user u where jc.course = :course and pc.status = 'Waiting'")
	public int countUserByWaitingStatus(@Param("course")Course course);
	
	@Query("select u from User u inner join u.comments c where c = :comment")
	public User findByComment(@Param("comment")Comment comment);

	@Query("select u from User u inner join u.userRoles ur inner join ur.role r where r.roleName = 'ROLE_Staff'")
	public List<User> findByStaffRole(Pageable pageable);
	
}
