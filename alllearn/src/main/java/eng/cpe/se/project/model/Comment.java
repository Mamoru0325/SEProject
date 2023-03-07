package eng.cpe.se.project.model;
// Generated Mar 5, 2023, 12:22:12 AM by Hibernate Tools 5.6.3.Final

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Comment generated by hbm2java
 */
public class Comment implements java.io.Serializable {

	private int commentId;
	@JsonIgnore
	@NotNull(message = "Post cannot be null")
	private Post post;
	@JsonIgnore
	@NotNull(message = "User cannot be null")
	private User user;
	@NotNull(message = "Comment cannot be null")
	@NotEmpty(message = "Comment may not be empty")
	private String commentDetail;
	@NotNull(message = "Comment cannot be null")
	@NotEmpty(message = "Comment may not be empty")
	private String reportStatus;
	@NotNull(message = "CreateDate cannot be null")
	@NotEmpty(message = "Password may not be empty")
	private Date createDate;
	@JsonIgnore
	private List<Report> reports = new ArrayList<Report>();
	@JsonIgnore
	private List<ImgComment> imgComments = new ArrayList<ImgComment>();
	@JsonIgnore
	private List<LikeComment> likeComments = new ArrayList<LikeComment>();

	public Comment() {
	}

	public Comment(Post post, User user, String commentDetail, String reportStatus, Date createDate) {
		this.post = post;
		this.user = user;
		this.commentDetail = commentDetail;
		this.reportStatus = reportStatus;
		this.createDate = createDate;
	}

	public Comment(Post post, User user, String commentDetail, String reportStatus, Date createDate, List<Report> reports, List<ImgComment> imgComments,
			List<LikeComment> likeComments) {
		this.post = post;
		this.user = user;
		this.commentDetail = commentDetail;
		this.reportStatus = reportStatus;
		this.createDate = createDate;
		this.reports = reports;
		this.imgComments = imgComments;
		this.likeComments = likeComments;
	}
	
	public void clone(Comment other) {
		this.commentDetail = other.commentDetail;
		this.reportStatus = other.reportStatus;
		this.createDate = other.createDate;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCommentDetail() {
		return commentDetail;
	}

	public void setCommentDetail(String commentDetail) {
		this.commentDetail = commentDetail;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public List<ImgComment> getImgComments() {
		return imgComments;
	}

	public void setImgComments(List<ImgComment> imgComments) {
		this.imgComments = imgComments;
	}

	public List<LikeComment> getLikeComments() {
		return likeComments;
	}

	public void setLikeComments(List<LikeComment> likeComments) {
		this.likeComments = likeComments;
	}

	public String getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}


}
