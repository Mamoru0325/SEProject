package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.Follower;
import eng.cpe.se.project.model.User;
import eng.cpe.se.project.repository.FollowerRepository;




@Service
public class FollowerService {
	@Autowired
	private FollowerRepository followerRepository; 
	@Autowired
	private UserService userService;
	
	public void save(Follower follower) {
		followerRepository.save(follower);
	}
	
	public List<Follower> findAll(){
		return (List<Follower>) followerRepository.findAll();
	}
	
	public Follower findById(int id) {
		return followerRepository.findById(id).get();
	}
	
	public void delete(int id) {
		followerRepository.deleteById(id);
	}
	
	public int countFollower(int userId) {
		User user = userService.findById(userId);
		return followerRepository.countFollower(user);
	}
}
