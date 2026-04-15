package io.github.Luiztins1.com.portobook.pbsystem.controller;

import io.github.Luiztins1.com.portobook.pbsystem.model.Book;
import io.github.Luiztins1.com.portobook.pbsystem.model.Employee;
import io.github.Luiztins1.com.portobook.pbsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<Employee> save(@RequestBody Employee employee){
        Employee employeeEntidade = employee;
        employeeService.saveEmployee(employee);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employeeEntidade.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> employeeList = employeeService.findAll();

        if(employeeList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id){
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") UUID id){
        Optional<Employee> employeeId = employeeService.findById(id);

        if(employeeId.isPresent()){
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
