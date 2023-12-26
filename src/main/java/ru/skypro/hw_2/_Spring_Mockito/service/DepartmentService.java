package ru.skypro.hw_2._Spring_Mockito.service;

import ru.skypro.hw_2._Spring_Mockito.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    List<Employee> getEmployees(Integer departmentId);
    Integer getSalarySum(Integer departmentId);
    Employee getEmployeeWithMaxSalary(Integer departmentId);
    Employee getEmployeeWithMinSalary(Integer departmentId);
   // List<Employee> getAllEmployeesByDepartment(Integer departmentId);
    Map<Integer, List<Employee>> getGroupedByDepartmentEmployees();
}
