package eng.cpe.se.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import eng.cpe.se.project.api.util.Response;
import eng.cpe.se.project.model.ContentType;
import eng.cpe.se.project.model.Course;
import eng.cpe.se.project.model.Post;
import eng.cpe.se.project.model.Report;
import eng.cpe.se.project.model.ReportType;
import eng.cpe.se.project.service.CourseService;
import eng.cpe.se.project.service.PostService;
import eng.cpe.se.project.service.ReportService;
import eng.cpe.se.project.service.ReportTypeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/reports")
@CrossOrigin("http://localhost:8081/")
public class ReportRestController {
	@Autowired
	private ReportService reportService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private PostService postService;
	@Autowired
	private ReportTypeService reportTypeService;
	
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
	@PreAuthorize("hasRole('Staff') or hasRole('SystemAdmin')")
	public ResponseEntity<Response<Report>> updateById(@PathVariable("id")int id) {
		Response<Report> res = new Response<>();
		try {
			Report re = reportService.findById(id);
			reportService.save(re);
			if(re.getCourse() != null) {
				int cid = re.getCourse().getCourseId();
				Course course = courseService.findById(cid);
				course.setReportStatus("Done");
				courseService.save(course);
			}
			if(re.getPost() != null) {
				int pid = re.getPost().getPostId();
				Post post = postService.findById(pid);
				post.setReportStatus("Done");
				postService.save(post);
			}
			res.setMessage("update "+id+"success");
			res.setBody(re);
			res.setHttpStatus(HttpStatus.OK);
			return new  ResponseEntity<Response<Report>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new  ResponseEntity<Response<Report>>(res, res.getHttpStatus());
		}
	}
	
	@GetMapping("/page/{page}/value/{value}")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('Staff') or hasRole('SystemAdmin')")
	public ResponseEntity<Response<List<Report>>> findAll(@PathVariable("page")int page,@PathVariable("value")int value) {
		Response<List<Report>> res = new Response<>();
		try {
			List<Report> re = reportService.findAll(page,value);
			res.setMessage("find success");
			res.setBody(re);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<List<Report>>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<List<Report>>>(res, res.getHttpStatus());
		}
	}
	
	@DeleteMapping("/{id}")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('Staff') or hasRole('SystemAdmin')")
	public ResponseEntity<Response<String>> deleteById(@PathVariable("id")int id){
		Response<String> res = new Response<String>();
		try {
			reportService.delete(id);
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
	
	@GetMapping("/{reportId}/reporttype")
	public ResponseEntity<Response<ReportType>> findReportTypeByReport(@PathVariable("reportId") int reportId) {
		Response<ReportType> res = new Response<>();
		Report report = reportService.findById(reportId);
		try {
			ReportType reportType = reportTypeService.findByReport(report);
			res.setMessage("find sucess");
			res.setBody(reportType);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<ReportType>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<ReportType>>(res, res.getHttpStatus());
		}
	}
	
}
