package eng.cpe.se.project.model.dto;

import eng.cpe.se.project.model.PaymentCheck;
import eng.cpe.se.project.model.User;

public class UserPaymentDTO {
	private User user;
	private PaymentCheck paymentCheck;
	
	public UserPaymentDTO() {
	
	}

	public UserPaymentDTO(User user, PaymentCheck paymentCheck) {
		super();
		this.user = user;
		this.paymentCheck = paymentCheck;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PaymentCheck getPaymentCheck() {
		return paymentCheck;
	}

	public void setPaymentCheck(PaymentCheck paymentCheck) {
		this.paymentCheck = paymentCheck;
	}
	
	
}
