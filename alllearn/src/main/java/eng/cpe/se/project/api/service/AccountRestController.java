package eng.cpe.se.project.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eng.cpe.se.project.api.util.Response;
import eng.cpe.se.project.model.Account;
import eng.cpe.se.project.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountRestController {

	@Autowired
	private AccountService accountService;

	@GetMapping(value = "/{id}")
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

	@PostMapping(value = "/")
	public ResponseEntity<Response<String>> createAccount(@RequestBody Account account) {
		Response<String> res = new Response<>();
		try {
			accountService.save(account);
			res.setMessage("Find  successfully.");
			res.setBody("OK");
			res.setHttpStatus(HttpStatus.OK);
			return new ResponseEntity<Response<String>>(res, res.getHttpStatus());
		} catch (Exception ex) {
			res.setMessage(ex.toString());
			res.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Response<String>>(res, res.getHttpStatus());
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
