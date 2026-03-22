package io.github.Luiztins1.com.portobook.pbsystem.controller;

import io.github.Luiztins1.com.portobook.pbsystem.model.Manager;
import io.github.Luiztins1.com.portobook.pbsystem.repository.ManagerRepository;
import io.github.Luiztins1.com.portobook.pbsystem.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping
    public Manager save(@RequestBody Manager manager){
        return managerService.saveManager(manager);
    }

    @GetMapping
    public List<Manager> findAll(){
        return managerService.findAll();
    }

    @PutMapping("/{id}")
    public Optional<Manager> update(@PathVariable("id") UUID id, @RequestBody Manager details){
        return managerService.updateManager(id, details);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id){
        managerService.delete(id);
    }

    @GetMapping("/{id}")
    public Optional<Manager> findById(@PathVariable("id") UUID id){
        return managerService.findById(id);
    }
}
