package io.github.Luiztins1.com.portobook.pbsystem.service;

import io.github.Luiztins1.com.portobook.pbsystem.model.Manager;
import io.github.Luiztins1.com.portobook.pbsystem.model.NormalEmployee;
import io.github.Luiztins1.com.portobook.pbsystem.repository.ManagerRepository;
import io.github.Luiztins1.com.portobook.pbsystem.repository.NormalEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NormalEmployeeService {

    private final NormalEmployeeRepository normalEmployeeRepository;

    public NormalEmployee saveNormalEmployee(NormalEmployee normalEmployee){
        return normalEmployeeRepository.save(normalEmployee);
    }

    public List<NormalEmployee> findAll(){
        return normalEmployeeRepository.findAll();
    }

    public void delete(UUID id){
        normalEmployeeRepository.deleteById(id);
    }

    public Optional<NormalEmployee> updateManager(UUID id, NormalEmployee details){
        return normalEmployeeRepository.findById(id).map(existNormalEmployee ->{
            existNormalEmployee.setName(details.getName());
            existNormalEmployee.setPassword(details.getPassword());
            return normalEmployeeRepository.save(existNormalEmployee);
        });
    }

    public Optional<NormalEmployee> findById(UUID id){
        return normalEmployeeRepository.findById(id);
    }
}
