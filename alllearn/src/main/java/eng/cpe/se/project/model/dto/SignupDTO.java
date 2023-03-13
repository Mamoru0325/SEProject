package eng.cpe.se.project.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import eng.cpe.se.project.model.User;
import eng.cpe.se.project.security.validation.PasswordMatches;

@PasswordMatches
public class SignupDTO {
	@Email
	private String email;
	private String username;
	private String title;
	private String password;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String imgPath;
	private String backgroundPath;
	private String verifyStatus;
	private String type;
	@NotBlank
	String matchingPassword;
	
	public SignupDTO(@Email String email, String username, String title, String password, String firstName,
			String lastName, String phoneNumber, String imgPath, String backgroundPath, String verifyStatus,
			String type, @NotBlank String matchingPassword) {
		super();
		this.email = email;
		this.username = username;
		this.title = title;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.imgPath = imgPath;
		this.backgroundPath = backgroundPath;
		this.verifyStatus = verifyStatus;
		this.type = type;
		this.matchingPassword = matchingPassword;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
	
	public String getMatchingPassword() {
		return matchingPassword;
	}
	
	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

}
