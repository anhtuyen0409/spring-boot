package com.nguyenanhtuyen.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nguyenanhtuyen.demo.entities.Employee;
import com.nguyenanhtuyen.demo.service.EmployeeService;

@RestController
@RequestMapping("/rest")
public class EmployeeRESTController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * list all of employees
	 * @return
	 */
	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = { 
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<Employee> getEmployees() {
		List<Employee> list = employeeService.getAllEmployees();
		return list;
	}

	/**
	 * get detail of employee
	 * @param empId
	 * @return
	 */
	@RequestMapping(value = "/employees/{empId}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Employee getEmployee(@PathVariable("empId") Long empId) {
		return employeeService.getEmployee(empId);
	}
	
	/**
	 * add employee
	 * @param empForm
	 * @return
	 */
	@RequestMapping(value = "/employees", method = RequestMethod.POST, produces = { 
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Employee addEmployee(@RequestBody Employee empForm) {
		System.out.println("(Server side) Creating employee with empNo: " + empForm.getEmpNo());
		return employeeService.addEmployee(empForm);
	}
	
	/**
	 * update employee
	 * @param empForm
	 * @return
	 */
	@RequestMapping(value = "/employees", method = RequestMethod.PUT, produces = { 
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Employee updateEmployee(@RequestBody Employee empForm) {
		System.out.println("(Server side) Update employee with Id: " + empForm.getEmpId());
		return employeeService.updateEmployee(empForm);
	}
	
	/**
	 * delete employee
	 * @param empId
	 * @return
	 */
	@RequestMapping(value = "/employees/{empId}", method = RequestMethod.DELETE, produces = { 
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public String deleteEmployee(@PathVariable("empId") Long empId) {
		System.out.println("(Server side) Delete employee with Id: " + empId);
		employeeService.deleteEmployee(empId);
		return "Delete success!";
	}
	
}
