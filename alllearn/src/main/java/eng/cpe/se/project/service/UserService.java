package eng.cpe.se.project.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eng.cpe.se.project.model.Role;
import eng.cpe.se.project.model.User;
import eng.cpe.se.project.model.UserRole;
import eng.cpe.se.project.repository.UserRepository;
import eng.cpe.se.project.security.exception.AccountAlreadyExistException;
import eng.cpe.se.project.security.service.UserDetailsImpl;
import eng.cpe.se.project.service.register.IUserService;


@Service
@Transactional
public class UserService implements IUserService, UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private RoleService roleService;
	
	
	public void save(User user) {
		userRepository.save(user);
	}
	
	public List<User> findAll(){
		return (List<User>) userRepository.findAll();
	}
	
	public User findById(int id) {
		return userRepository.findById(id).get();
	}
	
	public void delete(int id) {
		userRepository.deleteById(id);
	}
	
	private boolean emailExists(String email) {
		return userRepository.findByEmail(email) != null;
	}
	
	private boolean userNameExists(String userName) {
		return userRepository.findByUserName(userName) != null;
	}

	@Override
	public void registerNewAccount(User user,String roleName) throws AccountAlreadyExistException{
		if (emailExists(user.getEmail())) {
            throw new AccountAlreadyExistException("There is an account with that email address: " + user.getEmail());
        }else if(userNameExists(user.getUsername())) {
        	throw new AccountAlreadyExistException("There is an account with that userName : " + user.getUsername());
        }
		else {
			save(user);
			Role role = roleService.findByRoleName(roleName);
			UserRole userRole = new UserRole(role, user);
			userRoleService.save(userRole);
			user.getUserRoles().add(userRole);
        	
        }
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException("Email not found in the database");
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getUserRoles().forEach(userRole -> {
			authorities.add(new SimpleGrantedAuthority(userRole.getRole().getRoleName()));
		});
		return UserDetailsImpl.build(user);
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
	
	
}
