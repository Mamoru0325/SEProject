package eng.cpe.se.project.model;
// Generated Feb 24, 2023, 1:08:39 AM by Hibernate Tools 5.6.3.Final

/**
 * Requestcoursedetail generated by hbm2java
 */
public class RequestCourseDetail implements java.io.Serializable {

	private int requestCourseDetailId;
	private Course course;
	private RequestCourse requestCourse;

	public RequestCourseDetail() {
	}

	public RequestCourseDetail(int requestCourseDetailId, Course course, RequestCourse requestcourse) {
		this.requestCourseDetailId = requestCourseDetailId;
		this.course = course;
		this.setRequestCourse(requestcourse);
	}

	public int getRequestCourseDetailId() {
		return this.requestCourseDetailId;
	}

	public void setRequestCourseDetailId(int requestCourseDetailId) {
		this.requestCourseDetailId = requestCourseDetailId;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public RequestCourse getRequestCourse() {
		return requestCourse;
	}

	public void setRequestCourse(RequestCourse requestCourse) {
		this.requestCourse = requestCourse;
	}

	

}
