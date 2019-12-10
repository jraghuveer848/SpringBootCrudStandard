package com.raghu.personal.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.personal.dao.entity.Employee;
import com.raghu.personal.dao.repository.EmployeeRepository;
import com.raghu.personal.exception.RecordNotFoundException;
import com.raghu.personal.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employeeList = employeeRepository.findAll();
		if (employeeList.size() > 0) {
			return employeeList;
		} else {
			return new ArrayList<Employee>();
		}

	}

	@Override
	public Employee getEmployeeById(Long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee exists for given id");
		}

	}

	@Override
	public Employee createOrUpdateEmployee(Employee employee) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		Optional<Employee> emp = employeeRepository.findById(employee.getId());
		if (emp.isPresent()) {
			Employee newEmployee = emp.get();
			newEmployee.setEmail(employee.getEmail());
			newEmployee.setFirstName(employee.getFirstName());
			newEmployee.setLastName(employee.getLastName());
			newEmployee = employeeRepository.save(newEmployee);
			return newEmployee;
		} else {
			employee = employeeRepository.save(employee);
			return employee;
		}

	}

	@Override
	public void deleteEmployeeById(Long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			employeeRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee found");
		}
	}

}
