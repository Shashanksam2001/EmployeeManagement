package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Department;

public interface DepartmentService {
	Department createdepartment(Department department);
	List<Department> getAllDepartment();
	Optional<Department> getDepartmentByid(int id);
	Optional<Department> updateDepaertment(int id,Department department);
	String deleteDepartment(int id);


}
