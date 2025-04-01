package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepo;
@Service
public class DepartmentImplementation implements DepartmentService {
	@Autowired
	private DepartmentRepo departmentRepo;
	@Override
	public Department createdepartment(Department department) {
		
		return departmentRepo.save(department);
	}

	@Override
	public List<Department> getAllDepartment() {
		return departmentRepo.findAll();
	}

	@Override
	public Optional<Department> getDepartmentByid(int id) {
		// TODO Auto-generated method stub
		Optional<Department> dep1=departmentRepo.findById(id);
		return  dep1;
	}

	@Override
	public Optional<Department> updateDepaertment(int id, Department department) {
		return departmentRepo.findById(id).map(departments ->{
			departments.setName(department.getName());
			departments.setLocation(department.getLocation());
			return departmentRepo.save(department);
		});
	}

	@Override
	public String deleteDepartment(int id) {
		// TODO Auto-generated method stub
		departmentRepo.deleteById(id);
		return "Successfully deleted"+id;
	}

}
