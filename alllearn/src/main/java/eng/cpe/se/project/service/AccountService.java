package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.Account;
import eng.cpe.se.project.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	public void save(Account account) {
		accountRepository.save(account);
	}
	
	public List<Account> findAll(){
		return (List<Account>) accountRepository.findAll();
	}
	
	public Account findById(int id) {
		return accountRepository.findById(id).get();
	}
	
	public void delete(int id) {
		accountRepository.deleteById(id);
	}
	
	public Account findByName(String firstName) {
		return accountRepository.findByName(firstName);
	}
}
