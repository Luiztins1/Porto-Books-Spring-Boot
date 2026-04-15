package io.github.Luiztins1.com.portobook.pbsystem.controller;

import io.github.Luiztins1.com.portobook.pbsystem.model.NormalEmployee;
import io.github.Luiztins1.com.portobook.pbsystem.service.NormalEmployeeService;
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
@RequestMapping("/normal_employee")
@RequiredArgsConstructor
public class NormalEmployeeController {

    private final NormalEmployeeService normalEmployeeService;

    @PostMapping
    public ResponseEntity<NormalEmployee> save(@RequestBody NormalEmployee normalEmployee){
        NormalEmployee normalEmpl = normalEmployee;
        normalEmployeeService.saveNormalEmployee(normalEmpl);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(normalEmpl.getId_normal_employee())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<NormalEmployee>> findAll(){
        List<NormalEmployee> normalEmployeeList = normalEmployeeService.findAll();

        if(normalEmployeeList.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<NormalEmployee> update(@PathVariable("id") UUID id, @RequestBody NormalEmployee details){
        Optional<NormalEmployee>  normalEmployeeUpdate = normalEmployeeService.updateManager(id, details);

        if(normalEmployeeUpdate.isPresent()){
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id){
        normalEmployeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NormalEmployee> findById(@PathVariable("id") UUID id){
        Optional<NormalEmployee> normalEmployeeId = normalEmployeeService.findById(id);

        if(normalEmployeeId.isPresent()){
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
