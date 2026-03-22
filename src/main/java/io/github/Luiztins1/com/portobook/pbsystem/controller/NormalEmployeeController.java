package io.github.Luiztins1.com.portobook.pbsystem.controller;

import io.github.Luiztins1.com.portobook.pbsystem.model.NormalEmployee;
import io.github.Luiztins1.com.portobook.pbsystem.service.NormalEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/normal_employee")
public class NormalEmployeeController {

    private final NormalEmployeeService normalEmployeeService;

    @Autowired
    public NormalEmployeeController(NormalEmployeeService normalEmployeeService) {
        this.normalEmployeeService = normalEmployeeService;
    }

    @PostMapping
    public NormalEmployee save(@RequestBody NormalEmployee normalEmployee){
        return normalEmployeeService.saveNormalEmployee(normalEmployee);
    }

    @GetMapping
    public List<NormalEmployee> findAll(){
        return normalEmployeeService.findAll();
    }

    @PutMapping("/{id}")
    public Optional<NormalEmployee> update(@PathVariable("id") UUID id, @RequestBody NormalEmployee details){
        return normalEmployeeService.updateManager(id, details);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id){
        normalEmployeeService.delete(id);
    }

    @GetMapping("/{id}")
    public Optional<NormalEmployee> findById(@PathVariable("id") UUID id){
        return normalEmployeeService.findById(id);
    }
}
