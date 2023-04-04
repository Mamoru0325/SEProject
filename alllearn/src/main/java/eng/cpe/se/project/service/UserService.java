package eng.cpe.se.project.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import eng.cpe.se.project.model.Comment;
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
	@Autowired
	private CommentService commentService;
	
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
		User user = findById(id);
		File backgroundUser = new File(user.getBackgroundPath());
		File profileUser = new File(user.getImgPath());
		
		File profile = new File (externalPath+File.separator+"Userprofile"+File.separator+"Profile"+File.separator+"basic.png");
		File background = new File(externalPath+File.separator+"Userprofile"+File.separator+"Background"+File.separator+"basic.jpg");
		if (backgroundUser != background) {
			backgroundUser.deleteOnExit();
		}
		if (profileUser != profile) {
			profileUser.deleteOnExit();
		}
		
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


	public void saveProfile(MultipartFile file,int userId) throws IOException {
		// TODO Auto-generated method stub
		User user = findById(userId);
		String filename = externalPath+File.separator+"Userprofile"+File.separator+"Profile"+File.separator+userId+File.separator+"Profile";
		String type = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
		filename = filename + "." + type;
		
		OutputStream outputStream = new FileOutputStream(filename);
		outputStream.write(file.getBytes());
		outputStream.close();
		user.setImgPath(filename);
		save(user);
		
	}
	
	public void saveBackground(MultipartFile file,int userId) throws IOException {
		// TODO Auto-generated method stub
		User user = findById(userId);
		String filename = externalPath+File.separator+"Userprofile"+File.separator+"Background"+File.separator+userId+File.separator+"background";
		String type = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
		filename = filename + "." + type;
		
		OutputStream outputStream = new FileOutputStream(filename);
		outputStream.write(file.getBytes());
		outputStream.close();
		user.setBackgroundPath(filename);
		save(user);
		
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
	
	public List<User> findUserInCourseByWaitingStatus(int courseId){
		Course course = courseService.findById(courseId);
		return userRepository.findUserInCourseByWaitingStatus(course);
	}
	
	public List<User> findUserInCourseByPaidStatus(int courseId){
		Course course = courseService.findById(courseId);
		return userRepository.findUserInCourseByPaidStatus(course);
	}
	
	public int countUserByPaidStatus(int courseId) {
		Course course = courseService.findById(courseId);
		return userRepository.countUserByPaidStatus(course);
	}
	
	public int countUserByWaitingStatus(int courseId) {
		Course course = courseService.findById(courseId);
		return userRepository.countUserByWaitingStatus(course);
	}
	
	public User findBycomment(int id) {
		Comment comment = commentService.findById(id);
		return userRepository.findByComment(comment);
	}
	
	public List<User> findByStaffRole(int page,int value){
		Pageable pageable = PageRequest.of(page-1, value);
		return userRepository.findByStaffRole(pageable);
	}

}
