package eng.cpe.se.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.Staff;
import eng.cpe.se.project.repository.StaffRepository;

@Service
public class StaffService {
	@Autowired
	private StaffRepository staffRepository;
	
	public void save(Staff staff) {
		staffRepository.save(staff);
	}
	
	public List<Staff> findAll(){
		return (List<Staff>) staffRepository.findAll();
	}
	
	public Staff findById(int id) {
		return staffRepository.findById(id).get();
	}
	
	public void delete(int id) {
		staffRepository.deleteById(id);
	}
}
