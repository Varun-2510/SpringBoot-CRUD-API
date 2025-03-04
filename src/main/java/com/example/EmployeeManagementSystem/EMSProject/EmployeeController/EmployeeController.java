package com.example.EmployeeManagementSystem.EMSProject.EmployeeController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeManagementSystem.EMSProject.EmployeeEntity.EmployeeEntity;
import com.example.EmployeeManagementSystem.EMSProject.EmployeeServiceImpl.EmployeeServiceImpl;
import com.example.EmployeeManagementSystem.EMSProject.Exception.ResourceException;

@RestController
@RequestMapping("/api/employee")

public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	@PostMapping()
	public ResponseEntity<EmployeeEntity> addEmployee(@RequestBody EmployeeEntity data){
		EmployeeEntity emp = employeeServiceImpl.postData(data);
		return new ResponseEntity<>(emp , HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<List<EmployeeEntity>> getAllEmployee(){
		List data = employeeServiceImpl.getAllData();
		return new ResponseEntity<>(data , HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeEntity> getById(@PathVariable("id") Long id){
		EmployeeEntity emp = employeeServiceImpl.getDataById(id);
		return new ResponseEntity<>(emp , HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<EmployeeEntity> getByName(@RequestParam(name = "name") String name){
		EmployeeEntity emp = employeeServiceImpl.getDataByName(name);
		return new ResponseEntity<>(emp , HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable("id") Long id , 
			@RequestBody EmployeeEntity emp){
		String data = employeeServiceImpl.updateData(id, emp);
		return new ResponseEntity<>(data , HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
		String data = employeeServiceImpl.deleteData(id);
		return new ResponseEntity<>(data , HttpStatus.OK);
	}

	@GetMapping("/department/{department}")
	public ResponseEntity<List<EmployeeEntity>> getEmployeesByDepartment(@PathVariable("department") String department){
		List<EmployeeEntity> data = employeeServiceImpl.findByDepartment(department);
		return new ResponseEntity<>(data , HttpStatus.OK);
	}
	
	@GetMapping("/pageResp/")
	public ResponseEntity<List<EmployeeEntity>> getDataByPage(
			@RequestParam(name = "pageNumber") Integer pageNumber,
			@RequestParam(name = "pageSize") Integer pageSize
			){
		
		List<EmployeeEntity> data = employeeServiceImpl.getDataByPage(pageNumber, pageSize);
		return new ResponseEntity<>(data , HttpStatus.OK);
		
	}
}
