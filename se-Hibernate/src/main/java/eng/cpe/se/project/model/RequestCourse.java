package eng.cpe.se.project.model;
// Generated Mar 7, 2023, 9:28:55 AM by Hibernate Tools 5.6.3.Final

/**
 * Requestcourse generated by hbm2java
 */
public class RequestCourse implements java.io.Serializable {

	private Integer requestCourseId;
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

	public Integer getRequestCourseId() {
		return this.requestCourseId;
	}

	public void setRequestCourseId(Integer requestCourseId) {
		this.requestCourseId = requestCourseId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTopic() {
		return this.topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
