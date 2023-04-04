package eng.cpe.se.project.api.service;

import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.FieldError;
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
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.pheerathach.ThaiQRPromptPay;

import eng.cpe.se.project.api.util.Response;
import eng.cpe.se.project.model.ContentType;
import eng.cpe.se.project.model.Course;
import eng.cpe.se.project.model.ImgCourse;
import eng.cpe.se.project.model.ImgPost;
import eng.cpe.se.project.model.JoinCourse;
import eng.cpe.se.project.model.PaymentCheck;
import eng.cpe.se.project.model.Post;
import eng.cpe.se.project.model.Report;
import eng.cpe.se.project.model.ReportType;
import eng.cpe.se.project.model.User;
import eng.cpe.se.project.model.dto.UserPaymentDTO;
import eng.cpe.se.project.service.ContentTypeService;
import eng.cpe.se.project.service.CourseService;
import eng.cpe.se.project.service.ImgCommentService;
import eng.cpe.se.project.service.ImgCourseService;
import eng.cpe.se.project.service.JoinCourseService;
import eng.cpe.se.project.service.PaymentCheckService;
import eng.cpe.se.project.service.ReportService;
import eng.cpe.se.project.service.ReportTypeService;
import eng.cpe.se.project.service.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/courses")
@CrossOrigin("http://localhost:8081/")
public class CourseRestController {

	@Value("${external.resoures.path}")
	private String externalPath;
	private File file = new File(externalPath + File.separator + "Qrcode" + File.separator);
	@Autowired
	private CourseService courseService;
	@Autowired
	private UserService userService;
	@Autowired
	private ReportService reportService;
	@Autowired
	private JoinCourseService joinCourseService;
	@Autowired
	private PaymentCheckService paymentCheckService;
	@Autowired
	private ReportTypeService reportTypeService;
	@Autowired
	private ImgCourseService imgCourseService;
	@Autowired
	private ContentTypeService contentTypeService;

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

	@PostMapping("/{courseId}/report")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('User')")
	public ResponseEntity<Response<Report>> createReportByCourse(@PathVariable("courseId") int courseId,
			@RequestParam("reportTypeId") int reportTypeId, @Valid @RequestBody Report report) {
		Response<Report> res = new Response<Report>();
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Course course = courseService.findById(courseId);
		User user = userService.findByEmail(email);
		ReportType reportType = reportTypeService.findById(reportTypeId);
		try {
			course.setReportStatus("Waiting");
			courseService.save(course);
			report.setReportType(reportType);
			report.setUser(user);
			report.setCourse(course);
			reportService.save(report);
			res.setMessage("create report Success");
			res.setBody(report);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Report>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Report>>(res, res.getHttpStatus());
		}
	}

	@PostMapping("/{courseId}/payment")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('User')")
	public ResponseEntity<Response<PaymentCheck>> createPaymentByCourse(@PathVariable("courseId") int courseId) {
		Response<PaymentCheck> res = new Response<PaymentCheck>();
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println(email);
		Course course = courseService.findById(courseId);
		User courseCreator = userService.findById(course.getUser().getUserId());
		JoinCourse joinCourse = new JoinCourse(course);
		User user = userService.findByEmail(email);
		System.out.println(user.getEmail());
		PaymentCheck paymentCheck = new PaymentCheck();
		System.out.println(externalPath);
		System.out.println(file.getPath());
		try {
			joinCourseService.save(joinCourse);
			paymentCheck.setQrCodePath(paymentCheckService.createQrcode(courseId, courseCreator, course, joinCourse));

			paymentCheck.setJoinCourse(joinCourse);
			paymentCheck.setUser(user);
			paymentCheck.setStatus("Waiting");
			paymentCheckService.save(paymentCheck);
			res.setMessage("create payment Success");
			res.setBody(paymentCheck);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<PaymentCheck>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<PaymentCheck>>(res, res.getHttpStatus());
		}
	}

	@PutMapping("/{id}")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('CourseCreator') or hasRole('Staff') or hasRole('SystemAdmin')")
	public ResponseEntity<Response<Course>> updateById(@PathVariable("id") int id, @RequestBody Course course) {
		Response<Course> res = new Response<>();
		Course _course = courseService.findById(id);
		try {
			_course.clone(course);
			courseService.save(_course);
			res.setMessage("update " + id + "success");
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
	public ResponseEntity<Response<String>> deleteById(@PathVariable("id") int id) {
		Response<String> res = new Response<String>();
		try {
			courseService.delete(id);
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

	@GetMapping("/page/{page}/value/{value}")
	public ResponseEntity<Response<List<Course>>> findAll(@PathVariable("page") int page,
			@PathVariable("value") int value) {
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

	@GetMapping("/{courseId}/joincourses/paid")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('CourseCreator')")
	public ResponseEntity<Response<UserPaymentDTO>> findAllJoinUserByPaidStatus(
			@PathVariable("courseId") int courseId) {
		Response<UserPaymentDTO> res = new Response<>();
		try {
			List<User> user = userService.findUserInCourseByPaidStatus(courseId);
			int count = userService.countUserByWaitingStatus(courseId);
			UserPaymentDTO userPaymentDTos = new UserPaymentDTO();
			userPaymentDTos.setUser(user);
			userPaymentDTos.setCount(count);
			res.setMessage("find success");
			res.setBody(userPaymentDTos);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<UserPaymentDTO>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<UserPaymentDTO>>(res, res.getHttpStatus());
		}
	}

	@GetMapping("/{courseId}/joincourses/waiting")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('CourseCreator')")
	public ResponseEntity<Response<UserPaymentDTO>> findAllJoinUserByWaitingStatus(
			@PathVariable("courseId") int courseId) {
		Response<UserPaymentDTO> res = new Response<>();
		try {
			List<User> user = userService.findUserInCourseByWaitingStatus(courseId);
			int count = userService.countUserByWaitingStatus(courseId);
			UserPaymentDTO userPaymentDTos = new UserPaymentDTO();
			userPaymentDTos.setUser(user);
			userPaymentDTos.setCount(count);
			res.setMessage("find success");
			res.setBody(userPaymentDTos);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<UserPaymentDTO>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<UserPaymentDTO>>(res, res.getHttpStatus());
		}
	}

	@GetMapping("/user/page/{page}/value/{value}")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('User')")
	public ResponseEntity<Response<List<Course>>> findAllByUser(@PathVariable("page") int page,
			@PathVariable("value") int value) {
		Response<List<Course>> res = new Response<>();
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.findByEmail(email);
		try {
			List<Course> courses = courseService.findAllByUser(page, value, user);
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
	
	@GetMapping("/{courseId}/imgcourse")
	public ResponseEntity<Response<ImgCourse>> findImgCourseByCourse(@PathVariable("courseId") int courseId) {
		Response<ImgCourse> res = new Response<>();
		Course course = courseService.findById(courseId);
		try {
			ImgCourse img = imgCourseService.findByCourse(course);
			res.setMessage("find sucess");
			res.setBody(img);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<ImgCourse>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<ImgCourse>>(res, res.getHttpStatus());
		}
	}
	
	@GetMapping("/{courseId}/contenttype")
	public ResponseEntity<Response<ContentType>> findContentTypeByCourse(@PathVariable("courseId") int courseId) {
		Response<ContentType> res = new Response<>();
		Course course = courseService.findById(courseId);
		try {
			ContentType contentType = contentTypeService.findByCourse(course);
			res.setMessage("find sucess");
			res.setBody(contentType);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<ContentType>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<ContentType>>(res, res.getHttpStatus());
		}
	}

}
