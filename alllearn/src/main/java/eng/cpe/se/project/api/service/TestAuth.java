package eng.cpe.se.project.api.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/test")
public class TestAuth {
	
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/check/{id}")
	public String check(@Parameter(name = "coid") int coid,@PathVariable("id")int idp) {
		System.out.println(idp);
		System.out.println(coid);
		return "Public Content.";
	}

	@GetMapping("/user")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('User') or hasRole('Staff') or hasRole('SystemAdmin')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/staff")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('Staff') or hasRole('SystemAdmin')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('SystemAdmin')")
	public String adminAccess() {
		return "Admin Board.";
	}
}
