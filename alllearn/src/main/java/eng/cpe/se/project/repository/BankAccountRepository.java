package eng.cpe.se.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import eng.cpe.se.project.model.BankAccount;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {

}
