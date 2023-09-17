package com.example.demo.service;

import java.util.List;

import java.util.Optional;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.EmployeeResponse;
import com.example.demo.entity.Employee;


public interface EmployeeService {

//	List<Employee> getAllEmployees();
//	Employee getEmployeeById(int id);
//	Employee saveEmployee(Employee employee);
//	String updateEmployee(int id,Employee employee);
//	public void deleteAll();
//	String deleteEmployee(int id);
	
	
	 EmployeeDto saveEmployee(EmployeeDto employeeDto);
	 EmployeeDto getEmployeeById(long id);
	 EmployeeDto updateEmployee(EmployeeDto employeeDto, long id);
	 EmployeeResponse getAllEmployees(int pageNo, int pageSize, String sortBy, String sortDir);
	  void deleteEmployee(long id);

}
