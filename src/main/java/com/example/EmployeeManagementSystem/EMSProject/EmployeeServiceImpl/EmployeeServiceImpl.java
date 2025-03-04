package com.example.EmployeeManagementSystem.EMSProject.EmployeeServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.EmployeeManagementSystem.EMSProject.EmployeeEntity.EmployeeEntity;
import com.example.EmployeeManagementSystem.EMSProject.EmployeeRepo.EmployeeRepo;
import com.example.EmployeeManagementSystem.EMSProject.EmployeeService.EmployeeService;
import com.example.EmployeeManagementSystem.EMSProject.Exception.ResourceException;


@Service

public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public EmployeeEntity postData(EmployeeEntity data) {
		return employeeRepo.save(data);
	}

	@Override
	public List<EmployeeEntity> getAllData() {		
		return employeeRepo.findAll();
	}

	@Override
	public EmployeeEntity getDataById(Long id) {
		return employeeRepo.findById(id).orElseThrow(
				() -> new ResourceException("Employee not found with ID: " + id));
	}

	@Override
	public String updateData(Long id, EmployeeEntity data) {
		
		EmployeeEntity emp = getDataById(id);
		emp.setName(data.getName());
		emp.setEmail(data.getEmail());
		emp.setDepartment(data.getDepartment());
		
		employeeRepo.save(emp);
	
		return "Employee Updated Succesfully";
	}

	@Override
	public String deleteData(Long id) {
		
		Optional<EmployeeEntity> emp = Optional.of(getDataById(id));
		if(emp.isPresent()) {			
			employeeRepo.deleteById(id);
			return "Employee Deleted Successfully";
		}
		return "Employee Not Found";
	}

	@Override
	public List<EmployeeEntity> findByDepartment(String department) {
		return employeeRepo.findByDepartment(department);
	}

	@Override
	public EmployeeEntity getDataByName(String name) {

		return employeeRepo.getDataByName(name);
	}

	@Override
	public List<EmployeeEntity> getDataByPage(Integer pageNumber, Integer pageSize) {
		
		System.out.println(pageNumber , pageSize);
		
		Pageable page = PageRequest.of(pageNumber, pageSize);
		
		Page<EmployeeEntity> pageList = employeeRepo.findAll(page);
		
		List<EmployeeEntity> finalList = pageList.getContent();	
				
		return finalList;
	}

}
