package eng.cpe.se.project.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import eng.cpe.se.project.model.Course;
import eng.cpe.se.project.model.PaymentCheck;
import eng.cpe.se.project.model.Role;
import eng.cpe.se.project.model.User;
import eng.cpe.se.project.model.UserRole;
import eng.cpe.se.project.model.dto.UserPaymentDTO;
import eng.cpe.se.project.repository.UserRepository;
import eng.cpe.se.project.security.exception.AccountAlreadyExistException;
import eng.cpe.se.project.security.service.UserDetailsImpl;
import eng.cpe.se.project.service.register.IUserService;


@Service
@Transactional
public class UserService implements IUserService, UserDetailsService{

	@Value("${external.resoures.path}")
	private String externalPath;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private PaymentCheckService paymentCheckService;
	
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


	public void init() {
		// TODO Auto-generated method stub
		File folder = new File(externalPath+File.separator+"Userprofile"+File.separator);
		File profile = new File(externalPath+File.separator+"Userprofile"+File.separator+"Profile"+File.separator);
		File background = new File(externalPath+File.separator+"Userprofile"+File.separator+"Background"+File.separator);
		System.out.println(folder.getPath()+" "+profile.getPath()+" "+background);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		if (!profile.exists()) {
			profile.mkdirs();
		}
		if (!background.exists()) {
			background.mkdirs();
		}
	}


	public void save(MultipartFile file) {
		// TODO Auto-generated method stub
		
	}


	public Resource load(String filename) {
		// TODO Auto-generated method stub
		try {
			File file = new File(externalPath+File.separator+"Userprofile"+File.separator);
		      Resource resource = new UrlResource(file.toURI());

		      if (resource.exists() || resource.isReadable()) {
		        return resource;
		      } else {
		        throw new RuntimeException("Could not read the file!");
		      }
		    } catch (MalformedURLException e) {
		      throw new RuntimeException("Error: " + e.getMessage());
		    }
	}	
	
//	public List<UserPaymentDTO> findUserInCourseByWaitingStatus(int courseId){
//		List<UserPaymentDTO> userPaymentDTOs = new ArrayList<UserPaymentDTO>
//		Course course = courseService.findById(courseId);
//		List<User> users = userRepository.findUserInCourseByWaitingStatus(course);
//		List<PaymentCheck> paymentChecks = paymentCheckService.findInCourseByWaitingStatus(courseId);
//		int i = users.size();
//		int
//		for(int j = 0;j<i;j++) {
//			userPaymentDTOs[j]
//		}
//	}

}
