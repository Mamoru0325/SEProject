package eng.cpe.se.project.service.register;

import eng.cpe.se.project.model.Account;

public interface IAccountService {
	Account	registerNewAccount(Account userDto);
}
