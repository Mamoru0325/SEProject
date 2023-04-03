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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import eng.cpe.se.project.api.util.Response;
import eng.cpe.se.project.model.ReportType;
import eng.cpe.se.project.service.ReportTypeService;

@RestController
@RequestMapping("/reporttype")
@CrossOrigin("http://localhost:8081/")
public class ReportTypeRestController {
	
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
	
	@GetMapping("/")
	public ResponseEntity<Response<List<ReportType>>> findAll() {
		Response<List<ReportType>> res = new Response<>();
		try {
			List<ReportType> contentTypes = reportTypeService.findAll();
			res.setMessage("find success");
			res.setBody(contentTypes);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<List<ReportType>>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<List<ReportType>>>(res, res.getHttpStatus());
		}
	}

}
