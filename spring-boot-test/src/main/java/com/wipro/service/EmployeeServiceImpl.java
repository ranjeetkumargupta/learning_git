package com.wipro.service;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.wipro.dao.EmployeeRepository;
import com.wipro.entity.Employee;
import com.wipro.exception.RecordNotFoundException;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	EmployeeServiceImpl(EmployeeRepository employeeRepository){
		this.employeeRepository=employeeRepository;
	}
	
	public Employee save(Employee employee) {
		if (employee.getId() == null) {
			employee = employeeRepository.save(employee);
			return employee;
		} else {
			Optional<Employee> employeeOptional = employeeRepository.findById(employee.getId());
			if (employeeOptional.isPresent()) {
				Employee newEntity = employeeOptional.get();
				newEntity.setFirstName(employee.getFirstName());
				newEntity.setLastName(employee.getLastName());
				newEntity = employeeRepository.save(newEntity);
				return newEntity;
			} else {
				throw new RecordNotFoundException("No employee record exist for given id");
			}
		}
	}
	public List<Employee> findAll() {
		List<Employee> result = (List<Employee>) employeeRepository.findAll();
		if (result.isEmpty()) {
			return result;
		} else {
			return new ArrayList<>();
		}
	}
	public void deleteById(Integer id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			employeeRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}
	public void deleteAll() {
		employeeRepository.deleteAll();
	}
	@Override
	public Employee getEmployeeByFirstName(String firstName) {
		
		return employeeRepository.findByFirstName(firstName);
	}
}
