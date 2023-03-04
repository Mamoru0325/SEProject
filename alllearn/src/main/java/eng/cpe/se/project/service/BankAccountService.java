package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.BankAccount;
import eng.cpe.se.project.repository.BankAccountRepository;

@Service
public class BankAccountService {
	@Autowired
	private BankAccountRepository bankAccountRepository;
	
	public void save(BankAccount bankAccount) {
		bankAccountRepository.save(bankAccount);
	}
	
	public List<BankAccount> findAll(){
		return (List<BankAccount>) bankAccountRepository.findAll();
	}
	
	public BankAccount findById(int id) {
		return bankAccountRepository.findById(id).get();
	}
	
	public void delete(int id) {
		bankAccountRepository.deleteById(id);
	}
}
