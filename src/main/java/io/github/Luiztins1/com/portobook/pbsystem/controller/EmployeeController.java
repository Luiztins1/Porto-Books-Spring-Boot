package io.github.Luiztins1.com.portobook.pbsystem.controller;

import io.github.Luiztins1.com.portobook.pbsystem.model.Book;
import io.github.Luiztins1.com.portobook.pbsystem.model.Employee;
import io.github.Luiztins1.com.portobook.pbsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id){
        employeeService.delete(id);
    }

    @GetMapping("/{id}")
    public Optional<Employee> findById(@PathVariable("id") UUID id){
        return employeeService.findById(id);
    }
}
