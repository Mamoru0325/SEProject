package eng.cpe.se.project.model;
// Generated Feb 24, 2023, 1:08:39 AM by Hibernate Tools 5.6.3.Final

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Staff generated by hbm2java
 */
public class Staff implements java.io.Serializable {

	private int staffId;
	@JsonIgnore
	private Account account;
	private String position;
	@JsonIgnore
	private List<PaymentCheck> paymentChecks = new ArrayList<PaymentCheck>();
	@JsonIgnore
	private List<RequestVerify> requestVerifies = new ArrayList<RequestVerify>();
	@JsonIgnore
	private List<RequestCourse> requestCourses = new ArrayList<RequestCourse>();

	public Staff() {
	}

	public Staff(Account account, String position) {
		this.account = account;
		this.position = position;
	}

	public Staff(Account account, String position, List<PaymentCheck> paymentchecks, List<RequestVerify> requestverifies, List<RequestCourse> requestcourses) {
		this.account = account;
		this.position = position;
		this.setPaymentChecks(paymentchecks);
		this.setRequestVerifies(requestverifies);
		this.setRequestCourses(requestcourses);
	}

	public int getStaffId() {
		return this.staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public List<PaymentCheck> getPaymentChecks() {
		return paymentChecks;
	}

	public void setPaymentChecks(List<PaymentCheck> paymentChecks) {
		this.paymentChecks = paymentChecks;
	}

	public List<RequestVerify> getRequestVerifies() {
		return requestVerifies;
	}

	public void setRequestVerifies(List<RequestVerify> requestVerifies) {
		this.requestVerifies = requestVerifies;
	}

	public List<RequestCourse> getRequestCourses() {
		return requestCourses;
	}

	public void setRequestCourses(List<RequestCourse> requestCourses) {
		this.requestCourses = requestCourses;
	}

	

}
