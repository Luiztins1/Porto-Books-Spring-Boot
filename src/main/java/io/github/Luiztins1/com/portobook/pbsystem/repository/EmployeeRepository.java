package io.github.Luiztins1.com.portobook.pbsystem.repository;

import io.github.Luiztins1.com.portobook.pbsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
