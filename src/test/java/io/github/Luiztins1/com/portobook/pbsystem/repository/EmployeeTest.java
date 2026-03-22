package io.github.Luiztins1.com.portobook.pbsystem.repository;

import io.github.Luiztins1.com.portobook.pbsystem.model.Employee;
import io.github.Luiztins1.com.portobook.pbsystem.model.Manager;
import io.github.Luiztins1.com.portobook.pbsystem.model.NormalEmployee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    NormalEmployeeRepository normalEmployeeRepository;

    @Test
    public void saveEmployees(){
        Manager manager = new Manager();
        manager.setName("Gerente 1");
        manager.setPassword(12345678);

        NormalEmployee nremp = new NormalEmployee();
        nremp.setName("Funcionário 1");
        nremp.setPassword(12345678);

        Employee emp = new Employee();
        emp.setManager(manager);
        emp.setNormalEmployee(nremp);

        System.out.println(emp);
    }
}
