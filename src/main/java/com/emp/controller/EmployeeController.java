package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.entity.dto.EmployeeLogin;
import com.emp.entity.dto.JwtResponse;
import com.emp.entity.model.Employee;
import com.emp.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/Hello")
	public String hello()
	{
		return "Hello Gowtham.";
	}
	
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
        return employeeService.getEmployees();
    }
	
	
	@PostMapping("/employees")
	private boolean createEmployee(@RequestBody Employee employee)
	{
		try {
			System.out.println(employee.getName());
			employeeService.saveEmployee(employee);
		    return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	 @GetMapping("/employees/{id}")
	 private Employee getEmployee(@PathVariable("id") int emp_id)
	{
		Employee getEmployee= employeeService.getEmployeessById(emp_id);
	    return getEmployee;
	}

	@PutMapping("/employees/{id}")
	private Employee updateEmployee(@RequestBody Employee employee,@PathVariable("id") int emp_id)
	{
		employee.setId(emp_id);
		Employee updatedEmployee = employeeService.updateEmployee(employee);
	    return updatedEmployee ;	
	}

	@DeleteMapping("/employees/{id}")
	private String deleteEmployee(@PathVariable("id") int emp_id)
	{
		try {
			
			String result= employeeService.delete(emp_id);
		    return result;
		}
		catch(Exception e)
		{
			return "Error in Deletion";
		}
	}
}
