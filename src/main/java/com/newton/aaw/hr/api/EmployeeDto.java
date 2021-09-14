package com.newton.aaw.hr.api;

import com.newton.aaw.hr.domain.entity.Employee;
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
public class EmployeeDto {
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

    // construtor Entidade para DTO
    public EmployeeDto(Employee employee) {
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.dateOfBirth = employee.getDateOfBirth();
        this.gender = employee.getGender();
        this.startDate = employee.getStartDate();
        this.endDate = employee.getEndDate();
        this.position = employee.getPosition();
        this.monthlySalary = employee.getMonthlySalary();
        this.hourSalary = employee.getHourSalary();;
        this.area = employee.getArea();
    }

}
