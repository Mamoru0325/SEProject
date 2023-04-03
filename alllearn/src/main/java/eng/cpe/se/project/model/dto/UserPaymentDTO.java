package eng.cpe.se.project.model.dto;

import java.util.ArrayList;
import java.util.List;

import eng.cpe.se.project.model.PaymentCheck;
import eng.cpe.se.project.model.User;

public class UserPaymentDTO {
	private List<User> user =  new ArrayList<User>();
	private int count;
	
	public UserPaymentDTO() {
	
	}

	public UserPaymentDTO(List<User> user, int count) {
		super();
		this.user = user;
		this.count = count;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	
	
}
