package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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

@Controller
@RestController
@RequestMapping("/departments")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<String> createdep(@RequestBody Department department) {
		departmentService.createdepartment(department);
		return ResponseEntity.status(201).body("Department created successfully!");
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Department>> getAllDepaertmrnt(){
		return ResponseEntity.ok(departmentService.getAllDepartment());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Department>> GetDepartmrntByid(@PathVariable int id) {
		 Optional<Department> department = departmentService.getDepartmentByid(id);
		 return ResponseEntity.ok(department);
	}
	@PutMapping("/{id}")
	public ResponseEntity<String> updateDep(@PathVariable int id,@RequestBody Department department){
		departmentService.updateDepaertment(id, department);
		return ResponseEntity.ok("Updated");
		
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> DeleteByid(@PathVariable int id){
		departmentService.deleteDepartment(id);
		return ResponseEntity.ok("deleted");
	}
//	Create a Department → POST /departments
//
//	Get All Departments → GET /departments
//
//	Get Department by ID → GET /departments/{id}
//
//	Update Department → PUT /departments/{id}
//
//	Delete Department → DELETE /departments/{id}
	
}
