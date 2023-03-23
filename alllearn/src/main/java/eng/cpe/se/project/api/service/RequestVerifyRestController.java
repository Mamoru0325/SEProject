package eng.cpe.se.project.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import eng.cpe.se.project.api.util.Response;
import eng.cpe.se.project.model.RequestVerify;
import eng.cpe.se.project.service.RequestVerifyService;
@RestController
public class RequestVerifyRestController {
	
	@Autowired
	private RequestVerifyService requestVerifyService;
	
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
	public ResponseEntity<Response<RequestVerify>> updateUser(@PathVariable("id")int id) {
		Response<RequestVerify> res = new Response<>();
		try {
			RequestVerify r = requestVerifyService.findById(id);
			requestVerifyService.save(r);
			res.setMessage("update "+id+"success");
			res.setBody(r);
			res.setHttpStatus(HttpStatus.OK);
			return new  ResponseEntity<Response<RequestVerify>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new  ResponseEntity<Response<RequestVerify>>(res, res.getHttpStatus());
		}
	}
	
	@GetMapping("/page/{page}/value/{value}")
	public ResponseEntity<Response<List<RequestVerify>>> findById(@PathVariable("page")int page,@PathVariable("value")int value) {
		Response<List<RequestVerify>> res = new Response<>();
		try {
			List<RequestVerify> r = requestVerifyService.findAll(page,value);
			res.setMessage("find success");
			res.setBody(r);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<List<RequestVerify>>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<List<RequestVerify>>>(res, res.getHttpStatus());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Response<String>> deleteById(@PathVariable("id")int id){
		Response<String> res = new Response<String>();
		try {
			requestVerifyService.delete(id);
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
	
}