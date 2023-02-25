package eng.cpe.se.project.model;
// Generated Feb 24, 2023, 1:08:39 AM by Hibernate Tools 5.6.3.Final

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Requestcourse generated by hbm2java
 */
public class RequestCourse implements java.io.Serializable {

	private int requestCourseId;
	private Post post;
	private Staff staff;
	private User user;
	private String status;
	private Date dateApprove;
	private Date dateExprie;
	private List<RequestCourseDetail> requestCourseDetails = new ArrayList<RequestCourseDetail>();

	public RequestCourse() {
	}

	public RequestCourse(int requestCourseId, Post post, Staff staff, User user, String status, Date dateApprove,
			Date dateExprie) {
		this.requestCourseId = requestCourseId;
		this.post = post;
		this.staff = staff;
		this.user = user;
		this.status = status;
		this.dateApprove = dateApprove;
		this.dateExprie = dateExprie;
	}

	public RequestCourse(int requestCourseId, Post post, Staff staff, User user, String status, Date dateApprove,
			Date dateExprie, List<RequestCourseDetail> requestCourseDetails) {
		this.requestCourseId = requestCourseId;
		this.post = post;
		this.staff = staff;
		this.user = user;
		this.status = status;
		this.dateApprove = dateApprove;
		this.dateExprie = dateExprie;
		this.setRequestCourseDetails(requestCourseDetails);
	}

	public int getRequestCourseId() {
		return this.requestCourseId;
	}

	public void setRequestCourseId(int requestCourseId) {
		this.requestCourseId = requestCourseId;
	}

	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateApprove() {
		return this.dateApprove;
	}

	public void setDateApprove(Date dateApprove) {
		this.dateApprove = dateApprove;
	}

	public Date getDateExprie() {
		return this.dateExprie;
	}

	public void setDateExprie(Date dateExprie) {
		this.dateExprie = dateExprie;
	}

	public List<RequestCourseDetail> getRequestCourseDetails() {
		return requestCourseDetails;
	}

	public void setRequestCourseDetails(List<RequestCourseDetail> requestCourseDetails) {
		this.requestCourseDetails = requestCourseDetails;
	}

	

}
