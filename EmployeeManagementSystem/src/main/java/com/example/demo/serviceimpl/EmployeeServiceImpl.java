package com.example.demo.serviceimpl;



import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.EmployeeResponse;
import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.repository.EmployeeDao;
import com.example.demo.service.EmployeeService;



@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeedao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		//convert dto to entity
		Employee employee =mapToEntity(employeeDto);
		Employee newEmployee =employeedao.save(employee);
		
		//convert Entity to DTO
		EmployeeDto employeeResponse =mapToDTO(newEmployee);
	
		
		return employeeResponse;
	}
	
	
	//convert Entity to DTO
	private EmployeeDto mapToDTO(Employee employee) {
		EmployeeDto employeeDto =mapper.map(employee, EmployeeDto.class);
		return employeeDto;
	}
	//convert Dto to entity
	private Employee mapToEntity(EmployeeDto employeeDto) {
		Employee employee =mapper.map(employeeDto, Employee.class);
				return employee;
	}
	
	
	
	

	@Override
	public EmployeeDto getEmployeeById(long id) {
		Employee employee =employeedao.findById(id).orElseThrow( ()-> new EmployeeNotFoundException("Employee","id",id));
		return mapToDTO(employee);
	}





	@Override
	public EmployeeResponse getAllEmployees(int pageNo, int pageSize, String sortBy, String sortDir) {
		// TODO Auto-generated method stub
		Sort sort =sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				:Sort.by(sortBy).descending();

		// create pageable instance
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);	

		Page<Employee> employees = employeedao.findAll(pageable);
		
		// get content for page object
				List<Employee> listofPosts = employees.getContent();
				List<EmployeeDto> content = listofPosts.stream().map(employee -> mapToDTO(employee)).collect(Collectors.toList());
				EmployeeResponse employeeResponse = new EmployeeResponse();
				employeeResponse.setContent(content);
				employeeResponse.setPageNo(employees.getNumber());
				employeeResponse.setPageSize(employees.getSize());
				employeeResponse.setTotalElements(employees.getTotalElements());
				employeeResponse.setTotalPages(employees.getTotalPages());
				employeeResponse.setLast(employees.isLast());
				return employeeResponse;
	}


	@Override
	public void deleteEmployee(long id) {
		Employee employee = employeedao.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee", "id", id));
		employeedao.delete(employee);
	
	}


	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto,long id) {
		Employee employee =employeedao.findById(id).orElseThrow( ()-> new EmployeeNotFoundException("Employee","id",id));
		employee.setFirst_Name(employeeDto.getFirst_Name());
		employee.setLast_Name(employeeDto.getLast_Name());
		employee.setEmailId(employeeDto.getEmailId());
		
		Employee updatedEmployee =employeedao.save(employee);
		return mapToDTO(updatedEmployee);
	}


	





	

}
