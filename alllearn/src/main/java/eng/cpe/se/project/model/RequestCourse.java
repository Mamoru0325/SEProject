package eng.cpe.se.project.model;
// Generated Mar 7, 2023, 9:28:55 AM by Hibernate Tools 5.6.3.Final

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Requestcourse generated by hbm2java
 */
public class RequestCourse implements java.io.Serializable {

	private int requestCourseId;
	@JsonIgnore
	private User user;
	private String topic;
	private String detail;

	public RequestCourse() {
	}

	public RequestCourse(User user, String topic, String detail) {
		this.user = user;
		this.topic = topic;
		this.detail = detail;
	}
	
	public void clone(RequestCourse other) {
		this.user = other.user;
		this.topic = other.topic;
		this.detail = other.detail;
	}

	public int getRequestCourseId() {
		return requestCourseId;
	}

	public void setRequestCourseId(int requestCourseId) {
		this.requestCourseId = requestCourseId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}


}
