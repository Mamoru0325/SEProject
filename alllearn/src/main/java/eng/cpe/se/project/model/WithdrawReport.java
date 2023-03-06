package eng.cpe.se.project.model;
// Generated Mar 1, 2023, 12:55:07 AM by Hibernate Tools 5.6.3.Final

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Withdrawreport generated by hbm2java
 */
public class WithdrawReport implements java.io.Serializable {

	private int withdrawReportId;
	@JsonIgnore
	private User user;
	private float withdrawBalance;
	private Date dateWithdraw;
	@JsonIgnore
	private List<ApproveWithdrawDetail> approveWithdrawDetails = new ArrayList<ApproveWithdrawDetail>();

	public WithdrawReport() {
	}

	public WithdrawReport(User user, float withdrawBalance, Date dateWithdraw) {
		this.user = user;
		this.withdrawBalance = withdrawBalance;
		this.dateWithdraw = dateWithdraw;
	}

	public WithdrawReport(User user, float withdrawBalance, Date dateWithdraw, List<ApproveWithdrawDetail> approvewithdrawdetails) {
		this.user = user;
		this.withdrawBalance = withdrawBalance;
		this.dateWithdraw = dateWithdraw;
		this.approveWithdrawDetails = approvewithdrawdetails;
	}

	public Integer getWithdrawReportId() {
		return this.withdrawReportId;
	}

	public void setWithdrawReportId(Integer withdrawReportId) {
		this.withdrawReportId = withdrawReportId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public float getWithdrawBalance() {
		return withdrawBalance;
	}

	public void setWithdrawBalance(float withdrawBalance) {
		this.withdrawBalance = withdrawBalance;
	}

	public Date getDateWithdraw() {
		return dateWithdraw;
	}

	public void setDateWithdraw(Date dateWithdraw) {
		this.dateWithdraw = dateWithdraw;
	}

	public List<ApproveWithdrawDetail> getApproveWithdrawDetails() {
		return approveWithdrawDetails;
	}

	public void setApproveWithdrawDetails(List<ApproveWithdrawDetail> approveWithdrawDetails) {
		this.approveWithdrawDetails = approveWithdrawDetails;
	}

	public void setWithdrawReportId(int withdrawReportId) {
		this.withdrawReportId = withdrawReportId;
	}

	

}