package eng.cpe.se.project.model.dto;

import eng.cpe.se.project.model.Comment;
import eng.cpe.se.project.model.User;

public class UserCommentDTO {
	
	private User user;
	private Comment comment;
	
	public UserCommentDTO() {
	}

	public UserCommentDTO(User user, Comment comment) {
		this.user = user;
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
	

}
