package eng.cpe.se.project.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.ImgVerify;
import eng.cpe.se.project.model.RequestVerify;
import eng.cpe.se.project.model.Role;
import eng.cpe.se.project.model.User;
import eng.cpe.se.project.model.UserRole;
import eng.cpe.se.project.repository.RequestVerifyRepository;

@Service
public class RequestVerifyService {
	@Autowired
	private RequestVerifyRepository requestVerifyRepository;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private ImgVerifyService imgVerifyService;
	
	public void save(RequestVerify requestVerify) {
		requestVerifyRepository.save(requestVerify);
	}
	
	public List<RequestVerify> findAll(){
		return (List<RequestVerify>) requestVerifyRepository.findAll();
	}
	
	public RequestVerify findById(int id) {
		return requestVerifyRepository.findById(id).get();
	}
	
	public void delete(int id) {
		RequestVerify verify = findById(id);
		ImgVerify imgVerify = imgVerifyService.findByRequestVerify(verify);
		File img = new File(imgVerify.getImgPath());
		img.deleteOnExit();
		requestVerifyRepository.deleteById(id);
	}
	public List<RequestVerify> findAll(int page,int value){
		Pageable pageable = PageRequest.of(page, value);
		return (List<RequestVerify>) requestVerifyRepository.findAll(pageable);
	}
	
	public void checkVerify(RequestVerify requestVerify) {
		if(requestVerify.getApproveStatus().equals("Approve")) {
			Role role = roleService.findByRoleName("ROLE_CourseCreator");
			User user = requestVerify.getUserByUserId();
			UserRole userRole = new UserRole(role, user);
			userRoleService.save(userRole);
		}
	}
}
