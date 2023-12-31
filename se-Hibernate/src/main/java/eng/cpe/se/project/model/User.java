package eng.cpe.se.project.model;
// Generated Mar 7, 2023, 11:29:50 PM by Hibernate Tools 5.6.3.Final

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable {

	private Integer userId;
	private String email;
	private String password;
	private String title;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String username;
	private String imgPath;
	private String backgroundPath;
	private String verifyStatus;
	private String type;
	private List<PaymentCheck> paymentChecks = new ArrayList<PaymentCheck>();
	private List<Follower> followersForFollowBy = new ArrayList<Follower>();
	private List<Follower> followersForFollowTo = new ArrayList<Follower>();
	private List<Comment> comments = new ArrayList<Comment>();
	private List<RequestVerify> requestVerifiesForUserId = new ArrayList<RequestVerify>();
	private List<RequestCourse> requestCourses = new ArrayList<RequestCourse>();
	private List<Course> courses = new ArrayList<Course>();
	private List<RequestVerify> requestVerifiesForStaffId = new ArrayList<RequestVerify>();
	private List<Bookmark> bookmarks = new ArrayList<Bookmark>();
	private List<Post> posts = new ArrayList<Post>();
	private List<LikeComment> likeComments = new ArrayList<LikeComment>();
	private List<Report> reports = new ArrayList<Report>();
	private List<LikePost> likePosts = new ArrayList<LikePost>();
	private List<UserRole> userRoles = new ArrayList<UserRole>();

	public User() {
	}

	public User(String email, String password, String title, String firstName, String lastName, String phoneNumber,
			String username, String imgPath, String backgroundPath, String verifyStatus, String type) {
		this.email = email;
		this.password = password;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.imgPath = imgPath;
		this.backgroundPath = backgroundPath;
		this.verifyStatus = verifyStatus;
		this.type = type;
	}

	public User(Integer userId, String email, String password, String title, String firstName, String lastName,
			String phoneNumber, String username, String imgPath, String backgroundPath, String verifyStatus,
			String type, List<PaymentCheck> paymentChecks, List<Follower> followersForFollowBy,
			List<Follower> followersForFollowTo, List<Comment> comments, List<RequestVerify> requestVerifiesForUserId,
			List<RequestCourse> requestCourses, List<Course> courses, List<RequestVerify> requestVerifiesForStaffId,
			List<Bookmark> bookmarks, List<Post> posts, List<LikeComment> likeComments, List<Report> reports,
			List<LikePost> likePosts, List<UserRole> userRoles) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.imgPath = imgPath;
		this.backgroundPath = backgroundPath;
		this.verifyStatus = verifyStatus;
		this.type = type;
		this.paymentChecks = paymentChecks;
		this.followersForFollowBy = followersForFollowBy;
		this.followersForFollowTo = followersForFollowTo;
		this.comments = comments;
		this.requestVerifiesForUserId = requestVerifiesForUserId;
		this.requestCourses = requestCourses;
		this.courses = courses;
		this.requestVerifiesForStaffId = requestVerifiesForStaffId;
		this.bookmarks = bookmarks;
		this.posts = posts;
		this.likeComments = likeComments;
		this.reports = reports;
		this.likePosts = likePosts;
		this.userRoles = userRoles;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getBackgroundPath() {
		return backgroundPath;
	}

	public void setBackgroundPath(String backgroundPath) {
		this.backgroundPath = backgroundPath;
	}

	public String getVerifyStatus() {
		return verifyStatus;
	}

	public void setVerifyStatus(String verifyStatus) {
		this.verifyStatus = verifyStatus;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<PaymentCheck> getPaymentChecks() {
		return paymentChecks;
	}

	public void setPaymentChecks(List<PaymentCheck> paymentChecks) {
		this.paymentChecks = paymentChecks;
	}

	public List<Follower> getFollowersForFollowBy() {
		return followersForFollowBy;
	}

	public void setFollowersForFollowBy(List<Follower> followersForFollowBy) {
		this.followersForFollowBy = followersForFollowBy;
	}

	public List<Follower> getFollowersForFollowTo() {
		return followersForFollowTo;
	}

	public void setFollowersForFollowTo(List<Follower> followersForFollowTo) {
		this.followersForFollowTo = followersForFollowTo;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<RequestVerify> getRequestVerifiesForUserId() {
		return requestVerifiesForUserId;
	}

	public void setRequestVerifiesForUserId(List<RequestVerify> requestVerifiesForUserId) {
		this.requestVerifiesForUserId = requestVerifiesForUserId;
	}

	public List<RequestCourse> getRequestCourses() {
		return requestCourses;
	}

	public void setRequestCourses(List<RequestCourse> requestCourses) {
		this.requestCourses = requestCourses;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<RequestVerify> getRequestVerifiesForStaffId() {
		return requestVerifiesForStaffId;
	}

	public void setRequestVerifiesForStaffId(List<RequestVerify> requestVerifiesForStaffId) {
		this.requestVerifiesForStaffId = requestVerifiesForStaffId;
	}

	public List<Bookmark> getBookmarks() {
		return bookmarks;
	}

	public void setBookmarks(List<Bookmark> bookmarks) {
		this.bookmarks = bookmarks;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<LikeComment> getLikeComments() {
		return likeComments;
	}

	public void setLikeComments(List<LikeComment> likeComments) {
		this.likeComments = likeComments;
	}

	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public List<LikePost> getLikePosts() {
		return likePosts;
	}

	public void setLikePosts(List<LikePost> likePosts) {
		this.likePosts = likePosts;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}


}
