package io.github.Luiztins1.com.portobook.pbsystem.service;

import io.github.Luiztins1.com.portobook.pbsystem.model.Manager;
import io.github.Luiztins1.com.portobook.pbsystem.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ManagerService {

    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public Manager saveManager(Manager manager){
        return managerRepository.save(manager);
    }

    public List<Manager> findAll(){
        return managerRepository.findAll();
    }

    public void delete(UUID id){
        managerRepository.deleteById(id);
    }

    public Optional<Manager> updateManager(UUID id, Manager details){
        return managerRepository.findById(id).map(existManager ->{
            existManager.setName(details.getName());
            existManager.setPassword(details.getPassword());
            return managerRepository.save(existManager);
        });
    }

    public Optional<Manager> findById(UUID id){
        return managerRepository.findById(id);
    }
}
