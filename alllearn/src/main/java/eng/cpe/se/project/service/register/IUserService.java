package eng.cpe.se.project.service.register;

import eng.cpe.se.project.model.User;

public interface IUserService {
	void registerNewAccount(User user,String roleName);
}
