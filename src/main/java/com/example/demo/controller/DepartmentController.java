package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;


@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	//Add new department
	@PostMapping
	public ResponseEntity<String> createdep(@RequestBody Department department) {
		departmentService.createdepartment(department);
		return ResponseEntity.status(201).body("Department created successfully!");
	}
	
	//Add List of department
	@PostMapping("/add")
	public ResponseEntity<String> AddlistofJobs(@RequestBody List<Department> department) {
		String result=departmentService.saveAll(department);
		if("Department list cannot be empty".equals(result)) {
			return ResponseEntity.badRequest().body(result);
		}else {
			return ResponseEntity.ok(result);
		}
	}
	//get All the departments
	@GetMapping("/all")
	public ResponseEntity<List<Department>> getAllDepaertmrnt(){
		return ResponseEntity.ok(departmentService.getAllDepartment());
	}
	
	//getBy id
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Department>> GetDepartmrntByid(@PathVariable int id) {
		 Optional<Department> department = departmentService.getDepartmentByid(id);
		 return ResponseEntity.ok(department);
	}
	
	// update the existing records
	@PutMapping("/{id}")
	public ResponseEntity<String> updateDep(@PathVariable int id,@RequestBody Department department){
		departmentService.updateDepaertment(id, department);
		return ResponseEntity.ok("Updated");
	}
	
	//delete the records
	@DeleteMapping("/{id}")
	public ResponseEntity<String> DeleteByid(@PathVariable int id){
		departmentService.deleteDepartment(id);
		return ResponseEntity.ok("deleted");
	}	
}
