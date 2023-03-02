package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.User;
import eng.cpe.se.project.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
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
}
