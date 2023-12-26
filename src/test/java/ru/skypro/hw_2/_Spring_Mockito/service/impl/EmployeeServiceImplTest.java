package ru.skypro.hw_2._Spring_Mockito.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.skypro.hw_2._Spring_Mockito.exception.EmployeeAlreadyAddedException;
import ru.skypro.hw_2._Spring_Mockito.model.Employee;

public class EmployeeServiceImplTest {
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    @Test
    public void shouldThrowEmployeeAlreadyAddedExceptionWhenEmployeeIsAlreadyExisted() {
        //given
        Employee employee = new Employee("Ivan", "Petrov", 100_000, 1);
        employeeService.addEmployee(
                employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getDepartment()
        );
        //when
        //then
        Assertions.assertThrows(EmployeeAlreadyAddedException.class, () -> {
            employeeService.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getDepartment()
            );
        });
    }
    @Test
    public void shouldCorrectlyFindEmployee() {
        //given
        Employee employee = new Employee("Ivan", "Petrov", 100_000, 1);
        employeeService.addEmployee(
                employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getDepartment()
        );
        //when
        Employee actualEmployee = employeeService.findEmployee(employee.getFirstName(), employee.getLastName());
        //then
        Assertions.assertEquals(employee, actualEmployee);
    }
}
