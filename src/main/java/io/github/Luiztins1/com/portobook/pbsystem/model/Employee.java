package io.github.Luiztins1.com.portobook.pbsystem.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_employee")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_normal_employee", referencedColumnName = "id_normal_employee")
    private NormalEmployee normalEmployee;

    @ManyToOne
    @JoinColumn(name = "id_manager", referencedColumnName = "id_manager")
    private Manager manager;
}
