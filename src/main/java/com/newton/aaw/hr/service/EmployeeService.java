package com.newton.aaw.hr.service;

import com.newton.aaw.hr.domain.entity.Employee;
import com.newton.aaw.hr.domain.repository.EmployeeRepository;
import com.newton.aaw.hr.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public Employee create(Employee employee){
		employeeRepository.save(employee);
		return employee;
	}

	public Employee update (String id, Employee employee){
		var existing = get(id);

		existing.setArea(employee.getArea());
		existing.setEndDate(employee.getEndDate());
		existing.setDateOfBirth(employee.getDateOfBirth());
		existing.setGender(employee.getGender());
		existing.setFirstName(employee.getFirstName());
		existing.setHourSalary(employee.getHourSalary());
		existing.setLastName(employee.getLastName());
		existing.setPosition(employee.getPosition());
		existing.setMonthlySalary(employee.getMonthlySalary());
		existing.setStartDate(employee.getStartDate());

		employeeRepository.save(existing);

		return existing;
	}

	public Employee get(String id){
		var employee = employeeRepository.findById(id);

		if(employee.isEmpty()){
			throw new NotFoundException("Employee with ID " + id + " not found");
		}

		return employee.get();
	}

	public List<Employee> getAll(){ return employeeRepository.findAll(); }

	public void delete(String id){
		get(id);

		employeeRepository.deleteById(id);
	}
}
