package io.github.Luiztins1.com.portobook.pbsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "normal_employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NormalEmployee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_normal_employee", nullable = false)
    private UUID id_normal_employee;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @Column(name = "password", length = 8, nullable = false)
    private Integer password;

    @OneToMany(mappedBy = "normalEmployee")
    private List<Employee> normalEmployeeList;
}
