package eng.cpe.se.project.model;
// Generated Mar 7, 2023, 9:28:55 AM by Hibernate Tools 5.6.3.Final

/**
 * Imgcourse generated by hbm2java
 */
public class Imgcourse implements java.io.Serializable {

	private Integer imgCourseId;
	private Course course;
	private String imgPath;

	public Imgcourse() {
	}

	public Imgcourse(Course course, String imgPath) {
		this.course = course;
		this.imgPath = imgPath;
	}

	public Integer getImgCourseId() {
		return this.imgCourseId;
	}

	public void setImgCourseId(Integer imgCourseId) {
		this.imgCourseId = imgCourseId;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getImgPath() {
		return this.imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

}
