package eng.cpe.se.project.api.service;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.validation.FieldError;
import org.springframework.http.HttpStatus;

import eng.cpe.se.project.api.util.Response;
import eng.cpe.se.project.model.ContentType;
import eng.cpe.se.project.model.Course;
import eng.cpe.se.project.model.ImgPost;
import eng.cpe.se.project.model.Post;
import eng.cpe.se.project.model.RequestCourse;
import eng.cpe.se.project.model.RequestVerify;
import eng.cpe.se.project.model.User;
import eng.cpe.se.project.model.dto.UserCountDTO;
import eng.cpe.se.project.service.ContentTypeService;
import eng.cpe.se.project.service.CourseService;
import eng.cpe.se.project.service.FollowerService;
import eng.cpe.se.project.service.ImgCourseService;
import eng.cpe.se.project.service.ImgPostService;
import eng.cpe.se.project.service.ImgVerifyService;
import eng.cpe.se.project.service.PostService;
import eng.cpe.se.project.service.RequestCourseService;
import eng.cpe.se.project.service.RequestVerifyService;
import eng.cpe.se.project.service.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:8081/")
public class UserRestController {
	@Autowired
	private UserService userService;
	@Autowired
	private PostService postService;
	@Autowired
	private RequestVerifyService requestVerifyService;
	@Autowired
	private ContentTypeService contentTypeService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private FollowerService followerService;
	@Autowired
	private ImgPostService imgPostService;
	@Autowired
	private ImgCourseService imgCourseService;
	@Autowired
	private ImgVerifyService imgVerifyService;
	@Autowired
	private RequestCourseService requestCourseService;

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

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<Response<String>> handleMaxSizeException(MaxUploadSizeExceededException exc) {
		Response<String> res = new Response<String>();
		res.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
		res.setBody("File too large!");
		res.setMessage("File too large!");
		return new ResponseEntity<Response<String>>(res, res.getHttpStatus());
	}

	@PutMapping("/{id}")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('User')")
	public ResponseEntity<Response<User>> updateUserById(@PathVariable("id") int id, @RequestBody User user) {
		Response<User> res = new Response<>();
		try {
			User u = userService.findById(id);
			u.clone(user);
			userService.save(u);
			res.setMessage("update " + id + "success");
			res.setBody(u);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<User>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<User>>(res, res.getHttpStatus());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response<UserCountDTO>> findUserById(@PathVariable("id") int id) {
		Response<UserCountDTO> res = new Response<>();
		try {
			User u = userService.findById(id);
			int count = followerService.countFollower(id);
			UserCountDTO user = new UserCountDTO(u, count);
			res.setMessage("find success");
			res.setBody(user);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<UserCountDTO>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<UserCountDTO>>(res, res.getHttpStatus());
		}
	}

	@GetMapping("/username/{username}")
	public ResponseEntity<Response<UserCountDTO>> findUserByName(@PathVariable("username") String username) {
		Response<UserCountDTO> res = new Response<>();
		try {
			User u = userService.findByUserName(username);
			int count = followerService.countFollower(u.getUserId());
			UserCountDTO user = new UserCountDTO(u, count);
			res.setMessage("find success");
			res.setBody(user);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<UserCountDTO>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<UserCountDTO>>(res, res.getHttpStatus());
		}
	}

	@GetMapping("/email/{email}")
	public ResponseEntity<Response<UserCountDTO>> findUserByEmail(@PathVariable("email") String email) {
		Response<UserCountDTO> res = new Response<>();
		try {
			User u = userService.findByEmail(email);
			int count = followerService.countFollower(u.getUserId());
			UserCountDTO user = new UserCountDTO(u, count);
			res.setMessage("find success");
			res.setBody(user);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<UserCountDTO>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<UserCountDTO>>(res, res.getHttpStatus());
		}
	}

	@DeleteMapping("/{id}")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('User') or hasRole('Staff') or hasRole('SystemAdmin')")
	public ResponseEntity<Response<String>> deleteUserById(@PathVariable("id") int id) {
		Response<String> res = new Response<String>();
		try {
			userService.delete(id);
			res.setMessage("delete" + id + "success");
			res.setBody("");
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<String>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<String>>(res, res.getHttpStatus());
		}
	}

	@PostMapping("/post")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('User')")
	public ResponseEntity<Response<Post>> createPostByUser(@RequestParam("contentId") int contentId,
			@Valid @RequestBody Post post) {
		Response<Post> res = new Response<Post>();
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.findByEmail(email);
		ContentType contentType = contentTypeService.findById(contentId);
		try {
			post.setUser(user);
			post.setContentType(contentType);
			postService.save(post);
			res.setMessage("create Post Success");
			res.setBody(post);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Post>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Post>>(res, res.getHttpStatus());
		}
	}

	@PostMapping("/post/imgpost")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('User')")
	public ResponseEntity<Response<Post>> createPostByUser(@RequestParam(value = "file") MultipartFile file) {
		Response<Post> res = new Response<Post>();
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.findByEmail(email);
		Post post = postService.findByDateAndDoneReportStatus(user);
		try {
			imgPostService.saveimg(file, post);
			res.setMessage("create Post Success");
			res.setBody(post);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Post>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Post>>(res, res.getHttpStatus());
		}
	}

	@PostMapping("/requestverify")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('User')")
	public ResponseEntity<Response<RequestVerify>> createRequestVerifyByUser(@RequestParam("file") MultipartFile file,
			@Valid @RequestBody RequestVerify request) {
		Response<RequestVerify> res = new Response<RequestVerify>();
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.findByEmail(email);
		try {
			request.setUserByUserId(user);
			requestVerifyService.save(request);
			imgVerifyService.saveimg(file, request);
			res.setMessage("create RequestVerify Success");
			res.setBody(request);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<RequestVerify>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<RequestVerify>>(res, res.getHttpStatus());
		}
	}

	@PostMapping("/course")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('CourseCreator')")
	public ResponseEntity<Response<Course>> createCourseByUser(@RequestParam("file") MultipartFile file,
			@RequestParam("contentId") int contentId, @Valid @RequestBody Course course) {
		Response<Course> res = new Response<Course>();
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.findByEmail(email);
		ContentType contentType = contentTypeService.findById(contentId);
		try {
			course.setUser(user);
			course.setContentType(contentType);
			courseService.save(course);
			imgCourseService.saveimg(file, course);
			res.setMessage("create Course Success");
			res.setBody(course);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Course>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Course>>(res, res.getHttpStatus());
		}
	}

	@PostMapping("/{id}/requestcourse")
	public ResponseEntity<Response<RequestCourse>> createRequestCourse(@PathVariable("id") int id,
			@Valid @RequestBody RequestCourse requestCourse) {
		Response<RequestCourse> res = new Response<>();
		try {
			User u = userService.findById(id);
			requestCourse.setUser(u);
			res.setMessage("find success");
			res.setBody(requestCourse);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<RequestCourse>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<RequestCourse>>(res, res.getHttpStatus());
		}
	}

	@GetMapping("/{id}/requestcourse")
	public ResponseEntity<Response<List<RequestCourse>>> findRequestCourseByUser(@PathVariable("id") int id) {
		Response<List<RequestCourse>> res = new Response<>();
		try {
			User u = userService.findById(id);
			List<RequestCourse> requestCourses = requestCourseService.findByUser(u);
			res.setMessage("find success");
			res.setBody(requestCourses);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<List<RequestCourse>>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<List<RequestCourse>>>(res, res.getHttpStatus());
		}
	}

	@GetMapping("/staff/page/{page}/value/{value}")
	public ResponseEntity<Response<List<User>>> findUserByStaffRole(@PathVariable("page") int page,
			@PathVariable("value") int value) {
		Response<List<User>> res = new Response<>();
		try {
			List<User> users = userService.findByStaffRole(page, value);
			res.setMessage("find success");
			res.setBody(users);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<List<User>>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<List<User>>>(res, res.getHttpStatus());
		}
	}

}
