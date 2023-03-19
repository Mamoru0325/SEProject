package eng.cpe.se.project.model;
// Generated Mar 7, 2023, 11:29:50 PM by Hibernate Tools 5.6.3.Final

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Course generated by hbm2java
 */
public class Course implements java.io.Serializable {

	private Integer courseId;
	private ContentType contentType;
	private User user;
	private String courseTopic;
	private String courseDetail;
	private int minimum;
	private int maximum;
	private double price;
	private String status;
	private String reportStatus;
	private Date firstEnrollDate;
	private Date lastEnrollDate;
	private Date eventDate;
	private Date startDate;
	private Date endDate;
	private List<Report> reports = new ArrayList<Report>();
	private List<ImgCourse> imgCourses = new ArrayList<ImgCourse>();
	private List<JoinCourse> joinCourses = new ArrayList<JoinCourse>();

	public Course() {
	}

	public Course(Integer courseId, ContentType contentType, User user, String courseTopic, String courseDetail,
			int minimum, int maximum, double price, String status, String reportStatus, Date firstEnrollDate,
			Date lastEnrollDate, Date eventDate, Date startDate, Date endDate, List<Report> reports,
			List<ImgCourse> imgCourses, List<JoinCourse> joinCourses) {
		super();
		this.courseId = courseId;
		this.contentType = contentType;
		this.user = user;
		this.courseTopic = courseTopic;
		this.courseDetail = courseDetail;
		this.minimum = minimum;
		this.maximum = maximum;
		this.price = price;
		this.status = status;
		this.reportStatus = reportStatus;
		this.firstEnrollDate = firstEnrollDate;
		this.lastEnrollDate = lastEnrollDate;
		this.eventDate = eventDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reports = reports;
		this.imgCourses = imgCourses;
		this.joinCourses = joinCourses;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public ContentType getContentType() {
		return contentType;
	}

	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCourseTopic() {
		return courseTopic;
	}

	public void setCourseTopic(String courseTopic) {
		this.courseTopic = courseTopic;
	}

	public String getCourseDetail() {
		return courseDetail;
	}

	public void setCourseDetail(String courseDetail) {
		this.courseDetail = courseDetail;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}

	public Date getFirstEnrollDate() {
		return firstEnrollDate;
	}

	public void setFirstEnrollDate(Date firstEnrollDate) {
		this.firstEnrollDate = firstEnrollDate;
	}

	public Date getLastEnrollDate() {
		return lastEnrollDate;
	}

	public void setLastEnrollDate(Date lastEnrollDate) {
		this.lastEnrollDate = lastEnrollDate;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public List<ImgCourse> getImgCourses() {
		return imgCourses;
	}

	public void setImgCourses(List<ImgCourse> imgCourses) {
		this.imgCourses = imgCourses;
	}

	public List<JoinCourse> getJoinCourses() {
		return joinCourses;
	}

	public void setJoinCourses(List<JoinCourse> joinCourses) {
		this.joinCourses = joinCourses;
	}

}
