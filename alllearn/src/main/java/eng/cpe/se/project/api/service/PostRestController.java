package eng.cpe.se.project.api.service;

import java.util.ArrayList;
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
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import eng.cpe.se.project.api.util.Response;
import eng.cpe.se.project.model.Bookmark;
import eng.cpe.se.project.model.Comment;
import eng.cpe.se.project.model.ContentType;
import eng.cpe.se.project.model.Course;
import eng.cpe.se.project.model.ImgPost;
import eng.cpe.se.project.model.LikePost;
import eng.cpe.se.project.model.Post;
import eng.cpe.se.project.model.Report;
import eng.cpe.se.project.model.ReportType;
import eng.cpe.se.project.model.User;
import eng.cpe.se.project.service.BookmarkService;
import eng.cpe.se.project.service.CommentService;
import eng.cpe.se.project.service.ContentTypeService;
import eng.cpe.se.project.service.ImgCommentService;
import eng.cpe.se.project.service.ImgPostService;
import eng.cpe.se.project.service.LikePostService;
import eng.cpe.se.project.service.PostService;
import eng.cpe.se.project.service.ReportService;
import eng.cpe.se.project.service.ReportTypeService;
import eng.cpe.se.project.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/posts")
@CrossOrigin("http://localhost:8081/")
public class PostRestController {

	@Autowired
	private PostService postService;
	@Autowired
	private ReportService reportService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private UserService userService;
	@Autowired
	private LikePostService likePostService;
	@Autowired
	private BookmarkService bookmarkService;
	@Autowired
	private ReportTypeService reportTypeService;
	@Autowired
	private ImgPostService imgPostService;
	@Autowired
	private ImgCommentService imgCommentService;
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

	@GetMapping("/page/{page}/value/{value}")
	public ResponseEntity<Response<List<Post>>> findAll(@PathVariable("page") int page,
			@PathVariable("value") int value) {
		Response<List<Post>> res = new Response<>();
		try {
			List<Post> posts = postService.findAll(page, value);
			res.setMessage("find success");
			res.setBody(posts);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<List<Post>>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<List<Post>>>(res, res.getHttpStatus());
		}
	}

	@GetMapping("/lastestdate/page/{page}/value/{value}")
	public ResponseEntity<Response<List<Post>>> findAllByDateAndDoneReportStatus(@PathVariable("page") int page,
			@PathVariable("value") int value) {
		Response<List<Post>> res = new Response<>();
		try {
			List<Post> posts = postService.findAllByDateAndDoneReportStatus(page, value);
			res.setMessage("find success");
			res.setBody(posts);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<List<Post>>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<List<Post>>>(res, res.getHttpStatus());
		}
	}

	@GetMapping("/population/page/{page}/value/{value}")
	public ResponseEntity<Response<List<Post>>> findAllByPopulationAndDoneReportStatus(@PathVariable("page") int page,
			@PathVariable("value") int value) {
		Response<List<Post>> res = new Response<>();
		try {
			List<Post> posts = postService.findAllByPopulationAndDoneReportStatus(page, value);
			res.setMessage("find success");
			res.setBody(posts);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<List<Post>>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<List<Post>>>(res, res.getHttpStatus());
		}
	}

	@GetMapping("/{postId}/imgpost")
	public ResponseEntity<Response<ImgPost>> findImgPostByPost(@PathVariable("postId") int postId) {
		Response<ImgPost> res = new Response<>();
		Post post = postService.findById(postId);
		try {
			ImgPost img = imgPostService.findByPost(post);
			res.setMessage("find sucess");
			res.setBody(img);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<ImgPost>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<ImgPost>>(res, res.getHttpStatus());
		}
	}

	@PutMapping("/{id}")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('User') or hasRole('Staff') or hasRole('SystemAdmin')")
	public ResponseEntity<Response<Post>> updateById(@PathVariable("id") int id, @RequestBody Post post) {
		Response<Post> res = new Response<>();
		Post _post = postService.findById(id);
		try {
			_post.clone(post);
			postService.save(_post);
			res.setMessage("update " + id + "success");
			res.setBody(_post);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Post>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Post>>(res, res.getHttpStatus());
		}
	}

	@DeleteMapping("/{id}")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('USER') or hasRole('Staff') or hasRole('SystemAdmin')")
	public ResponseEntity<Response<String>> deleteById(@PathVariable("id") int id) {
		Response<String> res = new Response<String>();
		try {
			postService.delete(id);
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

	@PostMapping("/{postid}/report")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('User')")
	public ResponseEntity<Response<Report>> createReportByPost(@PathVariable("postid") int postid,
			@RequestParam("reportTypeId") int reportTypeId, @Valid @RequestBody Report report) {
		Response<Report> res = new Response<Report>();
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Post post = postService.findById(postid);
		User user = userService.findByEmail(email);
		ReportType reportType = reportTypeService.findById(reportTypeId);
		try {
			post.setReportStatus("Waiting");
			postService.save(post);
			report.setReportType(reportType);
			report.setUser(user);
			report.setPost(post);
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

	@PostMapping("/{postid}/bookmark")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('User')")
	public ResponseEntity<Response<Bookmark>> createBookmarkByPost(@PathVariable("postid") int postid,
			@Valid @RequestBody Bookmark bookmark) {
		Response<Bookmark> res = new Response<Bookmark>();
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Post post = postService.findById(postid);
		User user = userService.findByEmail(email);
		try {
			bookmark.setUser(user);
			bookmark.setPost(post);
			bookmarkService.save(bookmark);
			res.setMessage("create report Success");
			res.setBody(bookmark);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Bookmark>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Bookmark>>(res, res.getHttpStatus());
		}
	}

	@PostMapping("/{id}/comment")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('User')")
	public ResponseEntity<Response<Comment>> createCommentByPost(@RequestParam("file") MultipartFile file,
			@PathVariable("id") int id, @Valid @RequestBody Comment comment) {
		Response<Comment> res = new Response<Comment>();
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Post post = postService.findById(id);
		User user = userService.findByEmail(email);
		try {
			comment.setPost(post);
			comment.setUser(user);
			commentService.save(comment);
			imgCommentService.saveimg(file, comment);
			res.setMessage("create report Success");
			res.setBody(comment);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Comment>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Comment>>(res, res.getHttpStatus());
		}
	}

	@GetMapping("/{id}/page/{page}/value/{value}")
	public ResponseEntity<Response<List<Comment>>> findAllcomment(@PathVariable("id") int id,
			@PathVariable("page") int page, @PathVariable("value") int value) {
		Response<List<Comment>> res = new Response<>();
		Post post = postService.findById(id);
		try {
			List<Comment> comments = commentService.findAllByPost(post, page, value);
			res.setMessage("find success");
			res.setBody(comments);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<List<Comment>>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<List<Comment>>>(res, res.getHttpStatus());
		}
	}

	@PostMapping("/{id}/likepost")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('User')")
	public ResponseEntity<Response<LikePost>> likePost(@PathVariable("id") int id) {
		Response<LikePost> res = new Response<LikePost>();
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Post post = postService.findById(id);
		User user = userService.findByEmail(email);
		LikePost likePost = new LikePost(post, user);
		try {
			likePostService.save(likePost);
			res.setMessage("create report Success");
			res.setBody(likePost);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<LikePost>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<LikePost>>(res, res.getHttpStatus());
		}
	}

	@GetMapping("/follower/lastestdate/page/{page}/value/{value}")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('User')")
	public ResponseEntity<Response<List<Post>>> findAllByFollowerandDate(@PathVariable("page") int page,
			@PathVariable("value") int value) {
		Response<List<Post>> res = new Response<>();
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.findByEmail(email);
		try {
			List<Post> posts = postService.findAllByFollowerandDate(page, value, user);
			res.setMessage("find success");
			res.setBody(posts);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<List<Post>>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<List<Post>>>(res, res.getHttpStatus());
		}
	}

	@GetMapping("/follower/population/page/{page}/value/{value}")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('User')")
	public ResponseEntity<Response<List<Post>>> findAllByPopulationfromFollower(@PathVariable("page") int page,
			@PathVariable("value") int value) {
		Response<List<Post>> res = new Response<>();
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.findByEmail(email);
		try {
			List<Post> posts = postService.findAllByPopulationfromFollower(page, value, user);
			res.setMessage("find success");
			res.setBody(posts);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<List<Post>>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<List<Post>>>(res, res.getHttpStatus());
		}
	}
	
	@DeleteMapping("/{postId}/unlike")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('User')")
	public ResponseEntity<Response<String>> unlikeByPostAndUser(@PathVariable("postId") int postId) {
		Response<String> res = new Response<String>();
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.findByEmail(email);
		Post post = postService.findById(postId);
		try {
			LikePost likePost = likePostService.findByPostAndUser(post, user);
			likePostService.delete(likePost.getLikePostId());
			res.setMessage("delete" + likePost.getLikePostId() + "success");
			res.setBody("");
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<String>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<String>>(res, res.getHttpStatus());
		}
	}
	
	@GetMapping("/{postId}/contenttype")
	public ResponseEntity<Response<ContentType>> findContentTypeByPost(@PathVariable("postId") int postId) {
		Response<ContentType> res = new Response<>();
		Post post = postService.findById(postId);
		try {
			ContentType contentType = contentTypeService.findByPost(post);
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
	
	@GetMapping("/{postId}/likepost")
	public ResponseEntity<Response<Integer>> countLikePostByPost(@PathVariable("postId") int postId) {
		Response<Integer> res = new Response<>();
		Post post = postService.findById(postId);
		try {
			int likePost = likePostService.countLikePost(post);
			res.setMessage("find sucess");
			res.setBody(likePost);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Integer>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Integer>>(res, res.getHttpStatus());
		}
	}

//	@GetMapping("/{postId}/page/{page}/value/{value}")
//	public ResponseEntity<Response<List<UserCommentDTO>>> findAllByPost(@PathVariable("postId") int postId,
//			@PathVariable("page") int page, @PathVariable("value") int value) {
//		Response<List<UserCommentDTO>> res = new Response<>();
//		List<UserCommentDTO> dtos = new ArrayList<UserCommentDTO>();
//		Post post = postService.findById(postId);
//		List<Comment> comments = commentService.findAllByPost(post, page, value);
//		for(int i=0 ; i < comments.size();i++) {
//			int cid = comments.get(i).getCommentId();
//			User _user = userService.findBycomment(cid);
//			UserCommentDTO dto = new UserCommentDTO(_user, comments.get(i));
//			dtos.add(dto);
//		}
//		try {
//			res.setMessage("find success");
//			res.setBody(dtos);
//			res.setHttpStatus(HttpStatus.OK);
//			return new ResponseEntity<Response<List<UserCommentDTO>>>(res, res.getHttpStatus());
//		} catch (Exception ex) {
//			res.setBody(null);
//			res.setHttpStatus(HttpStatus.NOT_FOUND);
//			return new ResponseEntity<Response<List<UserCommentDTO>>>(res, res.getHttpStatus());
//		}
//	}

}
