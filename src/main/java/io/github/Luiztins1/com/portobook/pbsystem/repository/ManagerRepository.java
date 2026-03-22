package io.github.Luiztins1.com.portobook.pbsystem.repository;

import io.github.Luiztins1.com.portobook.pbsystem.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ManagerRepository extends JpaRepository<Manager, UUID> {
}
