package eng.cpe.se.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import eng.cpe.se.project.api.util.Response;
import eng.cpe.se.project.model.ImgPost;
import eng.cpe.se.project.service.ImgPostService;

@RestController
@RequestMapping("/imgposts")
@CrossOrigin("http://localhost:8081/")
public class ImgPostRestController {
	@Autowired
	private ImgPostService imgPostService;
	
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
	
	@GetMapping("/lastestdate/page/{page}/value/{value}")
	public ResponseEntity<Response<List<ImgPost>>> findAllByDateAndDoneReportStatus(@PathVariable("page") int page,
			@PathVariable("value") int value) {
		Response<List<ImgPost>> res = new Response<>();
		try {
			List<ImgPost> imgPosts = imgPostService.findAllByPostDate(page,value);
			res.setMessage("find success");
			res.setBody(imgPosts);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<List<ImgPost>>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<List<ImgPost>>>(res, res.getHttpStatus());
		}
	}

}
