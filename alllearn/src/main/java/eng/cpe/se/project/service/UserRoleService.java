package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.Role;
import eng.cpe.se.project.model.UserRole;
import eng.cpe.se.project.repository.UserRoleRepository;

@Service
public class UserRoleService {
	@Autowired
	private UserRoleRepository userRoleRepository;

	public void save(UserRole userRole) {
		userRoleRepository.save(userRole);
	}
	
	public List<UserRole> findAll(){
		return (List<UserRole>) userRoleRepository.findAll();
	}
	
	public UserRole findById(int id) {
		return userRoleRepository.findById(id).get();
	}
	
	public void delete(int id) {
		userRoleRepository.deleteById(id);
	}
}
