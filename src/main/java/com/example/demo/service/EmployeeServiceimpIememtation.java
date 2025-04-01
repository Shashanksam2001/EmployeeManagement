package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepo;
@Service
public class EmployeeServiceimpIememtation implements EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;
	

	@Override
	public Employee AddNewEmployee(Employee employee) {
		
		  if (employee.getDepartment() == null ) {
	            throw new RuntimeException("Department ID is required.");
	        }

//	        // Fetch the department from the database
//	        Department department = DepartmentRepo.findById(employee.getDepartment().getId())
//	            .orElseThrow(() -> new RuntimeException("Department not found"));
//
//	        employee.setDepartment(department); // Set the persistent entity

	        return employeeRepo.save(employee);
	}

	@Override
	public Optional<Employee> getEmployeeById(int id) {
		Optional<Employee> employeeByid=employeeRepo.findById(id);
		return employeeByid;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> allemployee=employeeRepo.findAll();
		return allemployee;
	}

	@Override
	public String deleteByid(int id) {
		// TODO Auto-generated method stub
		employeeRepo.deleteById(id);
		return ("The"+id+"was succesfully deleted");
	}

	@Override
	public Optional<Employee> updateEmployees(int id, Employee updatedEmployee) {
		return employeeRepo.findById(id).map(employee ->{
			employee.setFirstName(updatedEmployee.getFirstName());
			employee.setLastName(updatedEmployee.getLastName());
			employee.setEmail(updatedEmployee.getEmail());
			employee.setDateOfJoining(updatedEmployee.getDateOfJoining());
//			employee.setJob(updatedEmployee.getJob());
			employee.setPhone(updatedEmployee.getPhone());
			employee.setSalary(updatedEmployee.getSalary());
			return employeeRepo.save(employee);
		});
	}

}
