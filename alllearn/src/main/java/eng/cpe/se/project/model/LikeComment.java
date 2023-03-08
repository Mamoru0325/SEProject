package eng.cpe.se.project.model;
// Generated Mar 7, 2023, 11:29:50 PM by Hibernate Tools 5.6.3.Final

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Likecomment generated by hbm2java
 */
public class LikeComment implements java.io.Serializable {

	private Integer likeCommentId;
	@JsonIgnore
	private Comment comment;
	@JsonIgnore
	private User user;

	public LikeComment() {
	}

	public LikeComment(Comment comment, User user) {
		this.comment = comment;
		this.user = user;
	}

	public Integer getLikeCommentId() {
		return this.likeCommentId;
	}

	public void setLikeCommentId(Integer likeCommentId) {
		this.likeCommentId = likeCommentId;
	}

	public Comment getComment() {
		return this.comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
