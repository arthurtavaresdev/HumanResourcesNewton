package com.newton.aaw.hr.controller;

import com.newton.aaw.hr.api.EmployeeDto;
import com.newton.aaw.hr.domain.entity.Employee;
import com.newton.aaw.hr.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/{id}")
    public EmployeeDto getById(@PathVariable String id){
        var employee = employeeService.get(id);

        return new EmployeeDto(employee);
    }

    @GetMapping("/employees/")
    public List<EmployeeDto> getAll(){
        var employees = employeeService.getAll();

        var employeesDto = new ArrayList<EmployeeDto>();

        for (var employee: employees) {
            employeesDto.add(new EmployeeDto(employee));
        }

        return employeesDto;
    }

    @PostMapping("/employees")
    public EmployeeDto create(@RequestBody EmployeeDto employeeDto){
        var employee = new Employee(employeeDto);
        employee = employeeService.create(employee);

        return new EmployeeDto(employee);
    }

    @PutMapping("/employees/{id}")
    public EmployeeDto update(@PathVariable String id, @RequestBody EmployeeDto employeeDto){
        var employee = new Employee(employeeDto);
        employee = employeeService.update(id, employee);

        return new EmployeeDto(employee);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        employeeService.delete(id);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
