package com.example.EmployeeManagementSystem.EMSProject.EmployeeRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.EmployeeManagementSystem.EMSProject.EmployeeEntity.EmployeeEntity;

@Repository

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long>{
	
	@Query("SELECT e FROM EmployeeEntity e WHERE e.department = :department")
	List<EmployeeEntity> findByDepartment(@Param("department") String department);
	
	@Query("SELECT e FROM EmployeeEntity e WHERE e.name = :name")
	EmployeeEntity getDataByName(@Param("name") String name);

}
