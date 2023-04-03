package eng.cpe.se.project.model.dto;

import eng.cpe.se.project.model.User;

public class UserCountDTO {
	private User user;
	private int countFollowBy;
	
	public UserCountDTO() {
		
	}
	
	public UserCountDTO(User user, int countFollowBy) {
		super();
		this.user = user;
		this.countFollowBy = countFollowBy;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public int getCountFollowBy() {
		return countFollowBy;
	}
	
	public void setCountFollowBy(int countFollowBy) {
		this.countFollowBy = countFollowBy;
	}

}
