package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eng.cpe.se.project.model.Account;
import eng.cpe.se.project.repository.AccountRepository;
import eng.cpe.se.project.security.exception.AccountAlreadyExistException;
import eng.cpe.se.project.service.register.IAccountService;


@Service
@Transactional
public class AccountService implements IAccountService{
	
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
	
	private boolean emailExists(String email) {
		return accountRepository.findByEmail(email) != null;
	}

	@Override
	public Account registerNewAccount(Account account) {
		if (emailExists(account.getEmail())) {
            throw new AccountAlreadyExistException("There is an account with that email address: "
              + account.getEmail());
        }else {
        	return accountRepository.save(account);
        }
	}
}
