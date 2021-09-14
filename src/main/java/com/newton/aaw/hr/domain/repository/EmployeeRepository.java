package com.newton.aaw.hr.domain.repository;

import com.newton.aaw.hr.domain.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String>{ }
