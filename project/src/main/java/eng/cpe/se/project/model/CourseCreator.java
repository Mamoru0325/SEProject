package eng.cpe.se.project.model;
// Generated Feb 24, 2023, 1:08:39 AM by Hibernate Tools 5.6.3.Final

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Coursecreator generated by hbm2java
 */
public class CourseCreator implements java.io.Serializable {

	private int courseCreatorId;
	private User user;
	private float balance;
	private List<Course> courses = new ArrayList<Course>();

	public CourseCreator() {
	}

	public CourseCreator(int courseCreatorId, User user, float balance) {
		this.courseCreatorId = courseCreatorId;
		this.user = user;
		this.balance = balance;
	}

	public CourseCreator(int courseCreatorId, User user, float balance, List<Course> courses) {
		this.courseCreatorId = courseCreatorId;
		this.user = user;
		this.balance = balance;
		this.courses = courses;
	}

	public int getCourseCreatorId() {
		return this.courseCreatorId;
	}

	public void setCourseCreatorId(int courseCreatorId) {
		this.courseCreatorId = courseCreatorId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public float getBalance() {
		return this.balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public List<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
