package eng.cpe.se.project.model;
// Generated Feb 24, 2023, 1:08:39 AM by Hibernate Tools 5.6.3.Final

/**
 * Account generated by hbm2java
 */
public class Account implements java.io.Serializable {

	private int accountId;
	private String accountName;
	private String pwd;
	private String title;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private User user;
	private Staff staff;

	public Account() {
	}

	public Account(int accountId, String accountName, String pwd, String title, String firstName, String lastName,
			String phoneNumber) {
		this.accountId = accountId;
		this.accountName = accountName;
		this.pwd = pwd;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public Account(int accountId, String accountName, String pwd, String title, String firstName, String lastName,
			String phoneNumber, User user, Staff staff) {
		this.accountId = accountId;
		this.accountName = accountName;
		this.pwd = pwd;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.user = user;
		this.staff = staff;
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

}
