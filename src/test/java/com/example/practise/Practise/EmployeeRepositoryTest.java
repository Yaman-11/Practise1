package com.example.practise.Practise;

import com.example.practise.Practise.entity.Employee;
import com.example.practise.Practise.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Test
    public void show()
    {
        Employee employee=new Employee();
        employee.setEmployeeid(1);
        employee.setName("Yaman");
        employeeRepository.save(employee);
        Assert.assertNotNull(employee);
    }
    @Test
    public void add()
    {
        Employee employee=new Employee();
        employee.setEmployeeid(1);
        employee.setName("Yaman");
        Employee e=employeeRepository.save(employee);
        Assert.assertEquals(employee.getEmployeeid(),e.getEmployeeid());
        Assert.assertEquals(employee.getName(),e.getName());
    }

    @Test
    public void find()
    {
        Employee employee=new Employee();
        employee.setEmployeeid(1);
        employee.setName("Yaman");
        employeeRepository.save(employee);
        Employee e=employeeRepository.findById(employee.getEmployeeid()).get();
        Assert.assertEquals(employee.getName(),e.getName());
        Assert.assertEquals(employee.getEmployeeid(),e.getEmployeeid());
    }
    @Test
    public void name()
    {
        Employee employee=new Employee();
        employee.setEmployeeid(1);
        employee.setName("Yaman");
        employeeRepository.save(employee);
        Employee a=employeeRepository.findById(employee.getEmployeeid()).get();
        Assert.assertEquals(employee.getName(),a.getName());
    }

    @Test
    public void delete()
    {
        Employee employee=new Employee();
        employee.setEmployeeid(1);
        employee.setName("Yaman");
        employeeRepository.save(employee);
        employeeRepository.delete(employee);
        Assert.assertEquals(0,employeeRepository.count());
    }


}
