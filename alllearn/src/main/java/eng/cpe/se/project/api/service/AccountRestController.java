package eng.cpe.se.project.api.service;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.validation.FieldError;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import eng.cpe.se.project.api.util.Response;
import eng.cpe.se.project.model.Account;
import eng.cpe.se.project.service.AccountService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/accounts")
public class AccountRestController {

	@Autowired
	private AccountService accountService;

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

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<Response<Account>> findById(@PathVariable("id") int id) {
		Response<Account> res = new Response<>();
		try {
			Account account = accountService.findById(id);
			res.setBody(account);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Account>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Account>>(res, res.getHttpStatus());
		}
	}

	@PostMapping(value = "/registration")
	public ResponseEntity<Response<Account>> createAccount(@Valid@RequestBody Account account) {
		Response<Account> res = new Response<>();
		try {
			System.out.println(account.getEmail()+account.getFirstName());
			accountService.save(account);
			res.setMessage("save  successfully.");
			res.setBody(account);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Account>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setMessage(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Account>>(res, res.getHttpStatus());
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Response<String>> deleteAccount(@PathVariable("id") int id) {
		Response<String> res = new Response<>();
		try {
			accountService.delete(id);
			res.setMessage("Delete " + id + " successfully.");
			res.setBody("OK");
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<String>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setMessage("Result not found");
			res.setBody(ex.toString());
			res.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Response<String>>(res, res.getHttpStatus());
		}
	}

	@GetMapping(value = "/{firstName}")
	public ResponseEntity<Response<Account>> findById(@PathVariable("firstName") String firstName) {
		Response<Account> res = new Response<>();
		try {
			Account account = accountService.findByName(firstName);
			res.setBody(account);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<Account>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setBody(null);
			res.setHttpStatus(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response<Account>>(res, res.getHttpStatus());
		}
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Response<String>> updateAccount(@PathVariable("id") int id, @RequestBody Account account) {
		Response<String> res = new Response<>();
		try {
			Account a = accountService.findById(id);
			a.clone(account);
			accountService.save(a);
			res.setBody("");
			res.setMessage("update Id" + id);
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<String>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setMessage(ex.toString());
			res.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Response<String>>(res, res.getHttpStatus());
		}
	}
}
