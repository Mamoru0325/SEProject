package eng.cpe.se.project.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eng.cpe.se.project.model.Account;
import eng.cpe.se.project.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountRestController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping(value="/{id}")
	public Account findById(@PathVariable("id")int id) {
		return accountService.findById(id);
	}
	
	@PostMapping(value="/")
	public void createAccount(@RequestBody Account account) {
		
	}
}
