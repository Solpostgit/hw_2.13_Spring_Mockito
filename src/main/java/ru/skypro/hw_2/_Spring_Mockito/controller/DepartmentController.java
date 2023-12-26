package ru.skypro.hw_2._Spring_Mockito.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;
import ru.skypro.hw_2._Spring_Mockito.model.Employee;
import ru.skypro.hw_2._Spring_Mockito.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("{id}/employees")
    public List<Employee> getEmployee(@PathVariable("id") Integer id) {
        return departmentService.getEmployees(id);
    }

    @GetMapping("{id}/salary/sum")
    public Integer getSalarySum(@PathVariable("id") Integer id) {
        return departmentService.getSalarySum(id);
    }

    @GetMapping("{id}/salary/min")
    public Integer getEmployeeWithMinSalary(@PathVariable("id") Integer id) {
        return departmentService.getEmployeeWithMinSalary(id).getSalary();
    }

    @GetMapping("{id}/salary/max")
    public Integer getEmployeeWithMaxSalary(@PathVariable("id") Integer id) {
        return departmentService.getEmployeeWithMaxSalary(id).getSalary();
    }

    @GetMapping("employees")
    public Map<Integer, List<Employee>> getGroupedByDepartmentEmployees() {
        return departmentService.getGroupedByDepartmentEmployees();
    }
}
