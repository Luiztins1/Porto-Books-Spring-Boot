package io.github.Luiztins1.com.portobook.pbsystem.repository;

import io.github.Luiztins1.com.portobook.pbsystem.model.NormalEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NormalEmployeeRepository extends JpaRepository<NormalEmployee, UUID> {
}
