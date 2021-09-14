package com.newton.aaw.hr.domain.entity;

import com.newton.aaw.hr.api.EmployeeDto;
import com.newton.aaw.hr.domain.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private LocalDate startDate;
    private LocalDate endDate;
    private String position;
    private Float monthlySalary;
    private Float hourSalary;
    private String area;

    public Employee(EmployeeDto employeeDto) {
        this.firstName = employeeDto.getFirstName();
        this.lastName = employeeDto.getLastName();
        this.dateOfBirth = employeeDto.getDateOfBirth();
        this.gender = employeeDto.getGender();
        this.startDate = employeeDto.getStartDate();
        this.endDate = employeeDto.getEndDate();
        this.position = employeeDto.getPosition();
        this.monthlySalary = employeeDto.getMonthlySalary();
        this.hourSalary = employeeDto.getHourSalary();;
        this.area = employeeDto.getArea();
    }
}
