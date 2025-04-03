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

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

   
	@Autowired
	private EmployeeService employeeService;

	
	//Adding New Employee
	@PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.AddNewEmployee(employee));
    }
	
	//AddLsit of Employees
	@PostMapping("/add")
	public ResponseEntity<String> addlist(@RequestBody List<Employee> employee){
		String result=employeeService.saveAll(employee);
		if("employee list cannot be empty".equals(result)) {
			return ResponseEntity.badRequest().body(result);
		}else {
			return ResponseEntity.ok(result);
		}
	}
	
	//Get By id
	@GetMapping(("/{id}"))
	public ResponseEntity<Employee> GetByid(@PathVariable int id){
		Optional<Employee> employee = employeeService.getEmployeeById(id);
		return employee.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
	}
	
	//Get all Employees
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> GetAllEmployees(){
		return ResponseEntity.ok(employeeService.getAllEmployees()); 
	}
	
	//Delete by id
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id) {
	    employeeService.deleteByid(id);
	    return ResponseEntity.ok("Employee deleted successfully.");
	  
	}

	
	// update Employee
	@PutMapping("/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable int id,@RequestBody Employee updatedEmployee){
		employeeService.updateEmployees(id,updatedEmployee);
		return ResponseEntity.ok("Employee Record "+id+"updated");
	}

	

}
