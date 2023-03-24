package eng.cpe.se.project.api.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.FieldError;
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

import eng.cpe.se.project.api.util.Response;
import eng.cpe.se.project.model.Course;
import eng.cpe.se.project.model.Post;
import eng.cpe.se.project.model.Report;
import eng.cpe.se.project.model.User;
import eng.cpe.se.project.service.CourseService;
import eng.cpe.se.project.service.ReportService;
import eng.cpe.se.project.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/courses")
public class CourseRestController {
	@Autowired
	private CourseService courseService;
	@Autowired
	private UserService userService;
	@Autowired
	private ReportService reportService;
	
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
	
	@PostMapping("/{courseId}/report")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('User')")
	public ResponseEntity<Response<Report>> createReportByCourse(@PathVariable("courseId")int courseId, @Valid@RequestBody Report report){
		Response<Report> res = new Response<Report>();
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Course course = courseService.findById(courseId);
		User user = userService.findByEmail(email);
		try {
			report.setUser(user);
			report.setCourse(course);
			reportService.save(report);
			res.setMessage("create report Success");
			res.setBody(report);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Report>>(res, res.getHttpStatus());
		}catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Report>>(res, res.getHttpStatus());
		}
	}
	
	@PutMapping("/{id}")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('CourseCreator') or hasRole('Staff') or hasRole('SystemAdmin')")
	public ResponseEntity<Response<Course>> updateById(@PathVariable("id")int id,@RequestBody Course course){
		Response<Course> res = new Response<>();
		Course _course = courseService.findById(id);
		try {
			_course.clone(course);
			courseService.save(_course);
			res.setMessage("update "+id+"success");
			res.setBody(_course);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Course>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Course>>(res, res.getHttpStatus());
		}
	}
	
	@DeleteMapping("/{id}")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('USER') or hasRole('Staff') or hasRole('SystemAdmin')")
	public ResponseEntity<Response<String>> deleteById(@PathVariable("id")int id){
		Response<String> res = new Response<String>();
		try {
			courseService.delete(id);
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
	
	@GetMapping("/page/{page}/value/{value}")
	public ResponseEntity<Response<List<Course>>> findAll(@PathVariable("page")int page,@PathVariable("value")int value) {
		Response<List<Course>> res = new Response<>();
		try {
			List<Course> courses = courseService.findAll(page, value);
			res.setMessage("find success");
			res.setBody(courses);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<List<Course>>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<List<Course>>>(res, res.getHttpStatus());
		}
	}
}
