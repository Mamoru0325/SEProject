package eng.cpe.se.project.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
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
import eng.cpe.se.project.model.Course;
import eng.cpe.se.project.model.PaymentCheck;
import eng.cpe.se.project.service.PaymentCheckService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/payment")
@CrossOrigin("http://localhost:8081/")
public class PaymentRestController {
	@Autowired
	private PaymentCheckService paymentCheckService;
	
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
	
	 @ExceptionHandler(MaxUploadSizeExceededException.class)
	  public ResponseEntity<Response<String>> handleMaxSizeException(MaxUploadSizeExceededException exc) {
		 Response<String> res = new Response<String>();
		 res.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
		 res.setBody("File too large!");
		 res.setMessage("File too large!");
	    return new ResponseEntity<Response<String>>(res,res.getHttpStatus());
	  }
	 
	 @PutMapping("/{id}")
		@SecurityRequirement(name = "Bearer Authentication")
		@PreAuthorize("hasRole('User')")
		public ResponseEntity<Response<PaymentCheck>> updateById(@PathVariable("id")int id,
				@RequestParam("file") MultipartFile file){
			Response<PaymentCheck> res = new Response<>();
			PaymentCheck payment = paymentCheckService.findById(id);
			try {
				paymentCheckService.saveimg(file,id);
				res.setMessage("update "+id+"success");
				res.setBody(payment);
				res.setHttpStatus(HttpStatus.OK);
				return new ResponseEntity<Response<PaymentCheck>>(res, res.getHttpStatus());
			} catch (Exception ex) {
				res.setBody(null);
				res.setHttpStatus(HttpStatus.NOT_FOUND);
				return new ResponseEntity<Response<PaymentCheck>>(res, res.getHttpStatus());
			}
		}

}
