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

import eng.cpe.se.project.api.util.Response;
import eng.cpe.se.project.model.Comment;
import eng.cpe.se.project.model.ImgComment;
import eng.cpe.se.project.model.ImgCourse;
import eng.cpe.se.project.model.LikeComment;
import eng.cpe.se.project.model.LikePost;
import eng.cpe.se.project.model.Post;
import eng.cpe.se.project.model.Report;
import eng.cpe.se.project.model.ReportType;
import eng.cpe.se.project.model.User;
import eng.cpe.se.project.model.dto.UserCommentDTO;
import eng.cpe.se.project.service.CommentService;
import eng.cpe.se.project.service.ImgCommentService;
import eng.cpe.se.project.service.LikeCommentService;
import eng.cpe.se.project.service.ReportService;
import eng.cpe.se.project.service.ReportTypeService;
import eng.cpe.se.project.service.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/comments")
@CrossOrigin("http://localhost:8081/")
public class CommentRestController {

	@Autowired
	private CommentService commentService;
	@Autowired
	private LikeCommentService likeCommentService;
	@Autowired
	private UserService userService;
	@Autowired
	private ReportService reportService;
	@Autowired
	private ReportTypeService reportTypeService;
	@Autowired
	private ImgCommentService imgCommentService;

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
	@PreAuthorize("hasRole('User') or hasRole('Staff') or hasRole('SystemAdmin')")
	public ResponseEntity<Response<Comment>> updateById(@PathVariable("id") int id, @RequestBody Comment comment) {
		Response<Comment> res = new Response<>();
		Comment _comment = commentService.findById(id);
		try {
			_comment.clone(comment);
			commentService.save(_comment);
			res.setMessage("update " + id + "success");
			res.setBody(_comment);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Comment>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Comment>>(res, res.getHttpStatus());
		}
	}

	@PostMapping("/{id}/likecomment")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('User')")
	public ResponseEntity<Response<LikeComment>> likeComment(@PathVariable("id") int id) {
		Response<LikeComment> res = new Response<LikeComment>();
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Comment comment = commentService.findById(id);
		User user = userService.findByEmail(email);
		LikeComment likeComment = new LikeComment(comment, user);
		try {
			likeCommentService.save(likeComment);
			res.setMessage("create report Success");
			res.setBody(likeComment);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<LikeComment>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<LikeComment>>(res, res.getHttpStatus());
		}
	}

	@PostMapping("/{commentid}/report")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('User')")
	public ResponseEntity<Response<Report>> createReportByPost(@PathVariable("commentid") int commentid,
			@RequestParam("reportTypeId") int reportTypeId, @Valid @RequestBody Report report) {
		Response<Report> res = new Response<Report>();
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Comment comment = commentService.findById(commentid);
		User user = userService.findByEmail(email);
		ReportType reportType = reportTypeService.findById(reportTypeId);
		try {
			comment.setReportStatus("Waiting");
			commentService.save(comment);
			report.setReportType(reportType);
			report.setUser(user);
			report.setComment(comment);
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

	@DeleteMapping("/{id}")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('USER') or hasRole('Staff') or hasRole('SystemAdmin')")
	public ResponseEntity<Response<String>> deleteById(@PathVariable("id") int id) {
		Response<String> res = new Response<String>();
		try {
			commentService.delete(id);
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

	@GetMapping("/{id}")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('User')")
	public ResponseEntity<Response<User>> findAllByPopulationfromFollower(@PathVariable("id") int id) {
		Response<User> res = new Response<>();
		User user = userService.findBycomment(id);
		try {
			res.setMessage("find success");
			res.setBody(user);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<User>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<User>>(res, res.getHttpStatus());
		}
	}
	
	
	
	@GetMapping("/{commentId}/imgcourse")
	public ResponseEntity<Response<ImgComment>> findImgPostByPost(@PathVariable("commentId") int commentId) {
		Response<ImgComment> res = new Response<>();
		Comment commet = commentService.findById(commentId);
		try {
			ImgComment img = imgCommentService.findByComment(commet);
			res.setMessage("find sucess");
			res.setBody(img);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<ImgComment>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<ImgComment>>(res, res.getHttpStatus());
		}
	}
	
	@DeleteMapping("/{commentId}/unlike")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('User')")
	public ResponseEntity<Response<String>> unlikeByPostAndUser(@PathVariable("commentId") int commentId) {
		Response<String> res = new Response<String>();
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.findByEmail(email);
		Comment comment = commentService.findById(commentId);
		try {
			LikeComment likeComment = likeCommentService.findByCommentAndUser(comment, user);
			likeCommentService.delete(likeComment.getLikeCommentId());
			res.setMessage("delete" + likeComment.getLikeCommentId() + "success");
			res.setBody("");
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<String>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<String>>(res, res.getHttpStatus());
		}
	}
	
	@GetMapping("/{commentId}/likecomment")
	public ResponseEntity<Response<Integer>> countLikeCommentByComment(@PathVariable("commentId") int commentId) {
		Response<Integer> res = new Response<>();
		Comment comment = commentService.findById(commentId);
		try {
			int likeComment = likeCommentService.countLikeComment(comment);
			res.setMessage("find sucess");
			res.setBody(likeComment);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Integer>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Integer>>(res, res.getHttpStatus());
		}
	}

}
