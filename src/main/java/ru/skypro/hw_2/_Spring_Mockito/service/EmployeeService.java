package ru.skypro.hw_2._Spring_Mockito.service;

import ru.skypro.hw_2._Spring_Mockito.model.Employee;

import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, Integer salary, Integer department);
    void removeEmployee (String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    Map<String, Employee> getAllEmployees();
}
