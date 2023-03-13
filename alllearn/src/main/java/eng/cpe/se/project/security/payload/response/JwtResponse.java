package eng.cpe.se.project.security.payload.response;

import java.util.List;

import eng.cpe.se.project.model.Role;
import eng.cpe.se.project.model.User;

public class JwtResponse {
	private String token;
	private static final String type = "Bearer";
	private String userName;
	private List<String> roles;
	
	public JwtResponse() {
		
	}

	public JwtResponse(String token, String userName, List<String> roles) {
		super();
		this.token = token;
		this.userName = userName;
		this.roles = roles;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	
	

}
