package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.RequestCourse;
import eng.cpe.se.project.model.Role;
import eng.cpe.se.project.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	public void save(Role role) {
		roleRepository.save(role);
	}
	
	public List<Role> findAll(){
		return (List<Role>) roleRepository.findAll();
	}
	
	public Role findById(int id) {
		return roleRepository.findById(id).get();
	}
	
	public void delete(int id) {
		roleRepository.deleteById(id);
	}
	
	public Role findByRoleName(String roleName) {
		return roleRepository.findByRoleName(roleName);
	}
}
