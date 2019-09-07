package com.raghu.personal.service;

import java.util.List;

import com.raghu.personal.dao.entity.Employee;
import com.raghu.personal.exception.RecordNotFoundException;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee getEmployeeById(Long id) throws RecordNotFoundException;

	Employee createOrUpdateEmployee(Employee employee) throws RecordNotFoundException;

	void deleteEmployeeById(Long id) throws RecordNotFoundException;

}
