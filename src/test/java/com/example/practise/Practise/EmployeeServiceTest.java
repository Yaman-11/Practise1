package com.example.practise.Practise;


import com.example.practise.Practise.entity.Employee;
import com.example.practise.Practise.repository.EmployeeRepository;
import com.example.practise.Practise.service.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class EmployeeServiceTest {
    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void show() {
        Employee employee = new Employee();
        employee.setEmployeeid(1);
        employee.setName("Yaman");
        employeeRepository.save(employee);
        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee));
        List<Employee> e = employeeService.show();
        Assert.assertEquals(Arrays.asList(employee), e);
    }

    @Test
    public void add() {
        Employee employee = new Employee();
        employee.setEmployeeid(1);
        employee.setName("Yama");
        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee));
        String e = employeeService.add(employee);
        Assert.assertEquals("Added Successfully", e);
    }

    @Test
    public void find()
    {
        Employee employee = new Employee();
        employee.setEmployeeid(1);
        employee.setName("Yaman");
        when(employeeRepository.findById(employee.getEmployeeid())).thenReturn(java.util.Optional.of(employee));
        Employee e=employeeService.find(employee.getEmployeeid());
        Assert.assertEquals(employee,e);
    }
    @Test
    public void name()
    {
        Employee employee = new Employee();
        employee.setEmployeeid(1);
        employee.setName("Yaman");
        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee));
        String e= employeeService.name(1);
        Assert.assertEquals(employee.getName(),e);
    }
    @Test
    public void delete()
    {
        Employee employee = new Employee();
        employee.setEmployeeid(1);
        employee.setName("Yaman");
        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee));
        String s=employeeService.delete(employee.getEmployeeid());
       Assert.assertEquals("DELETED SUCCESSFULLY",s);
    }

}
