package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Employee;

public interface EmployeeService {

	Employee AddNewEmployee(Employee employee);
	Optional<Employee> getEmployeeById(int id);
	List<Employee>  getAllEmployees();
	String deleteByid(int id);
	Optional<Employee> updateEmployees(int id, Employee updatedEmployee);
	String saveAll(List<Employee> employee);
	




}
