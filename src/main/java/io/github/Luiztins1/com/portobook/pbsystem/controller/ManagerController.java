package io.github.Luiztins1.com.portobook.pbsystem.controller;

import io.github.Luiztins1.com.portobook.pbsystem.model.Manager;
import io.github.Luiztins1.com.portobook.pbsystem.repository.ManagerRepository;
import io.github.Luiztins1.com.portobook.pbsystem.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/manager")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @PostMapping
    public ResponseEntity<Manager> save(@RequestBody Manager manager) {
        Manager managerEntidade = manager;
        managerService.saveManager(managerEntidade);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(managerEntidade.getId_manager())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<Manager>> findAll() {
        List<Manager> managerList = managerService.findAll();

        if(managerList.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manager> update(@PathVariable("id") UUID id, @RequestBody Manager details){
        Optional<Manager> managerUpdate = managerService.updateManager(id, details);

        if(managerUpdate.isPresent()){
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        managerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manager> findById(@PathVariable("id") UUID id){
        Optional<Manager> managerId = managerService.findById(id);

        if(managerId.isPresent()) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
