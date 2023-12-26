package ru.skypro.hw_2._Spring_Mockito.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.hw_2._Spring_Mockito.model.Employee;
import ru.skypro.hw_2._Spring_Mockito.service.DepartmentService;
import ru.skypro.hw_2._Spring_Mockito.service.EmployeeService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee> getEmployees(Integer departmentId) {
        return employeeService.getAllEmployees().values().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .collect(Collectors.toList());
    }

    @Override
    public Integer getSalarySum(Integer departmentId) {
        return employeeService.getAllEmployees().values().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .map(Employee::getSalary)
                .mapToInt(Integer::intValue)
                .sum();
    }

    @Override
    public Employee getEmployeeWithMaxSalary(Integer departmentId) {
        return employeeService.getAllEmployees().values().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee getEmployeeWithMinSalary(Integer departmentId) {
        return employeeService.getAllEmployees().values().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Map<Integer, List<Employee>> getGroupedByDepartmentEmployees() {
        return employeeService.getAllEmployees().values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}

