package net.eezn.mybatis.controller;

import lombok.RequiredArgsConstructor;
import net.eezn.mybatis.mapper.EmployeeMapper;
import net.eezn.mybatis.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeMapper employeeMapper;

    @PostMapping
    public int insert(@RequestBody Employee employee) {
        return employeeMapper.insert(employee);
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable("id") int id) {
        return employeeMapper.getById(id);
    }

    @GetMapping("/")
    public List<Employee> getAll() {
        return employeeMapper.getAll();
    }

    @GetMapping
    public List<Employee> getByCompanyId(@RequestParam("company") int companyId) {
        return employeeMapper.getByCompanyId(companyId);
    }
}
