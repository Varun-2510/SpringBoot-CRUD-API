package com.example.EmployeeManagementSystem.EMSProject.EmployeeService;

import java.util.List;

import com.example.EmployeeManagementSystem.EMSProject.EmployeeEntity.EmployeeEntity;

public interface EmployeeService {
	
	public EmployeeEntity postData(EmployeeEntity data);
	
	public List<EmployeeEntity> getAllData();
	
	public EmployeeEntity getDataById(Long id);
	
	public String updateData(Long id , EmployeeEntity data);
	
	public String deleteData(Long id);
	
	public List<EmployeeEntity> findByDepartment(String department);
	
	public EmployeeEntity getDataByName(String name);
	
	public List<EmployeeEntity> getDataByPage(Integer pageNumber , Integer pageSize);

}
