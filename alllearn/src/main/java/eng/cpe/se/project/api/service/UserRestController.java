package eng.cpe.se.project.api.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.validation.FieldError;
import org.springframework.http.HttpStatus;

import eng.cpe.se.project.api.util.Response;
import eng.cpe.se.project.model.ContentType;
import eng.cpe.se.project.model.Post;
import eng.cpe.se.project.model.RequestVerify;
import eng.cpe.se.project.model.User;
import eng.cpe.se.project.service.ContentTypeService;
import eng.cpe.se.project.service.PostService;
import eng.cpe.se.project.service.RequestVerifyService;
import eng.cpe.se.project.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@RestController
@RequestMapping("/users")
public class UserRestController {
	@Autowired
	private UserService userService;
	@Autowired
	private PostService postService;
	@Autowired
	private RequestVerifyService requestVerifyService;
	@Autowired
	private ContentTypeService contentTypeService;
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response<ObjectNode>> handleValidationExceptions(MethodArgumentNotValidException ex){
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
        return new ResponseEntity<Response<ObjectNode>>(res,res.getHttpStatus());
    }
	
	@PutMapping("/{id}")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('User')")
	public ResponseEntity<Response<User>> updateUserById(@PathVariable("id")int id) {
		Response<User> res = new Response<>();
		try {
			User u = userService.findById(id);
			u.setFirstName("ppppp");
			userService.save(u);
			res.setMessage("update "+id+"success");
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
	public ResponseEntity<Response<User>> findUserById(@PathVariable("id")int id) {
		Response<User> res = new Response<>();
		try {
			User u = userService.findById(id);
			res.setMessage("find success");
			res.setBody(u);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<User>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<User>>(res, res.getHttpStatus());
		}
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<Response<User>> findUserById(@PathVariable("username")String username) {
		Response<User> res = new Response<>();
		try {
			User u = userService.findByUserName(username);
			res.setMessage("find success");
			res.setBody(u);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<User>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<User>>(res, res.getHttpStatus());
		}
	}
	
	@DeleteMapping("/{id}")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('User') or hasRole('Staff') or hasRole('SystemAdmin')")
	public ResponseEntity<Response<String>> deleteUserById(@PathVariable("id")int id){
		Response<String> res = new Response<String>();
		try {
			userService.delete(id);
			res.setMessage("delete"+ id + "success");
			res.setBody("");
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<String>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<String>>(res, res.getHttpStatus());
		}
	}
	
	@PostMapping("/post/contentid/{id}")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('User')")
	public ResponseEntity<Response<Post>> createPostByUser(@PathVariable("id")int id,@Valid@RequestBody Post post){
		Response<Post> res = new Response<Post>();
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.findByEmail(email);
		ContentType contentType = contentTypeService.findById(id);
		try {
			post.setUser(user);
			post.setContentType(contentType);
			postService.save(post);
			res.setMessage("create Post Success");
			res.setBody(post);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Post>>(res, res.getHttpStatus());
		}catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Post>>(res, res.getHttpStatus());
		}
	}
	
	@PostMapping("/requestverify")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('User')")
	public ResponseEntity<Response<RequestVerify>> createRequestVerifyByUser(@Valid@RequestBody RequestVerify request){
		Response<RequestVerify> res = new Response<RequestVerify>();
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.findByEmail(email);
		try {
			request.setUserByUserId(user);
			requestVerifyService.save(request);
			res.setMessage("create Post Success");
			res.setBody(request);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<RequestVerify>>(res, res.getHttpStatus());
		}catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<RequestVerify>>(res, res.getHttpStatus());
		}
	}
	
}
