package eng.cpe.se.project.api.service;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import eng.cpe.se.project.api.util.Response;
import eng.cpe.se.project.model.User;
import eng.cpe.se.project.model.dto.LoginDTO;
import eng.cpe.se.project.model.dto.SignupDTO;
import eng.cpe.se.project.security.exception.AccountAlreadyExistException;
import eng.cpe.se.project.security.jwt.JwtUtils;
import eng.cpe.se.project.security.payload.response.JwtResponse;
import eng.cpe.se.project.security.service.UserDetailsImpl;
import eng.cpe.se.project.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@RestController
@RequestMapping("/auth")
@CrossOrigin("http://localhost:8081/")
public class AuthRestController {
	@Value("${external.resoures.path}")
	private String externalPath;
	@Autowired
	private UserService userService;
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Response<ObjectNode>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Response<ObjectNode> res = new Response<>();
		res.setHttpStatus(HttpStatus.BAD_REQUEST);

		ObjectMapper mapper = new ObjectMapper();

		ObjectNode responObject = mapper.createObjectNode();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldname = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			responObject.put(fieldname, errorMessage);
		});
		res.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
		res.setBody(responObject);
		return new ResponseEntity<Response<ObjectNode>>(res, res.getHttpStatus());
	}

	@PostMapping("/signup")
	public ResponseEntity<Response<SignupDTO>> registerUser(@Valid @RequestBody SignupDTO user) {
		Response<SignupDTO> res = new Response<>();
		try {
			String roleName = "ROLE_User";
			User _user = new User();
			_user.signup(user);
			_user.setPassword(encoder.encode(_user.getPassword()));
			_user.setBackgroundPath(externalPath+File.separator+"Userprofile"+File.separator+"Background"+File.separator+"basic.jpg");
			_user.setImgPath(externalPath+File.separator+"Userprofile"+File.separator+"Profile"+File.separator+"basic.png");
			userService.registerNewAccount(_user, roleName);
			res.setMessage("Register Success");
			res.setBody(user);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<SignupDTO>>(res, res.getHttpStatus());
		} catch (AccountAlreadyExistException uaeEx) {
			res.setMessage("An account for that username/email already exists.");
			res.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Response<SignupDTO>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<SignupDTO>>(res, res.getHttpStatus());
		}
	}
	
	@PostMapping("/signup/staff")
	public ResponseEntity<Response<SignupDTO>> registerStaff(@Valid @RequestBody SignupDTO user) {
		Response<SignupDTO> res = new Response<>();
		try {
			String roleName = "ROLE_Staff";
			User _user = new User();
			_user.signup(user);
			_user.setPassword(encoder.encode(_user.getPassword()));
			userService.registerNewAccount(_user, roleName);
			res.setMessage("Register Success");
			res.setBody(user);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<SignupDTO>>(res, res.getHttpStatus());
		} catch (AccountAlreadyExistException uaeEx) {
			res.setMessage("An account for that username/email already exists.");
			res.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Response<SignupDTO>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<SignupDTO>>(res, res.getHttpStatus());
		}
	}

	@PostMapping("/signin")
	public ResponseEntity<Response<JwtResponse>> authenticateUser(@Valid @RequestBody LoginDTO loginRequest) {
		Response<JwtResponse> res = new Response<>();
		UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
				loginRequest.getPassword());
		final Authentication authentication = authenticationManager.authenticate(authReq);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateToken(authentication);
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		res.setBody(new JwtResponse(jwt, userDetails.getUsername(), roles));
		res.setHttpStatus(HttpStatus.OK);
		res.setMessage("ok");
		return new ResponseEntity<Response<JwtResponse>>(res, res.getHttpStatus());
	}
}
