package com.example.practise.Practise;

import com.example.practise.Practise.controller.EmployeeController;
import com.example.practise.Practise.entity.Employee;
import com.example.practise.Practise.service.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class EmployeeControllerTest {
    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeService employeeService;

    @Test
    public void show() {
        Employee employee = new Employee();
        employee.setEmployeeid(1);
        employee.setName("Yaman");
        when(employeeService.show()).thenReturn(Arrays.asList(employee));
        Assert.assertEquals(Arrays.asList(employee), employeeController.show());
    }

    @Test
    public void add() {
        Employee employee = new Employee();
        employee.setEmployeeid(1);
        employee.setName("Yaman");
        when(employeeService.add(employee)).thenReturn("ADDED SUCCESSFULLY");
        Assert.assertEquals(new ResponseEntity<String>("ADDED SUCCESSFULLY", HttpStatus.OK),
                employeeController.add(employee));
    }

    @Test
    public void find() {
        Employee employee = new Employee();
        employee.setEmployeeid(1);
        employee.setName("Yaman");
        when(employeeService.find(employee.getEmployeeid())).thenReturn(employee);
        Assert.assertEquals(employee, employeeController.find(employee.getEmployeeid()));
    }

    @Test
    public void name() {
        Employee employee = new Employee();
        employee.setName("Yaman");
        employee.setEmployeeid(1);
        when(employeeService.name(employee.getEmployeeid())).thenReturn(employee.getName());
        Assert.assertEquals(new ResponseEntity<String>(employee.getName(), HttpStatus.OK),
                employeeController.name(employee.getEmployeeid()));
    }

    @Test
    public void nameNotSuccess() {
        Employee employee = new Employee();
        employee.setName("Yaman");
        employee.setEmployeeid(1);
        when(employeeService.name(employee.getEmployeeid())).thenReturn("ID NOT FOUND");
        Assert.assertEquals(new ResponseEntity<String>("ID NOT FOUND", HttpStatus.BAD_REQUEST), employeeController.name(employee.getEmployeeid()));
    }

    @Test
    public void delete() {
        Employee employee = new Employee();
        employee.setEmployeeid(1);
        employee.setName("Yaman");
        when(employeeService.delete(employee.getEmployeeid())).thenReturn("DELETED SUCCESSFULLY");
        Assert.assertEquals(new ResponseEntity<String>("DELETED SUCCESSFULLY", HttpStatus.OK)
                , employeeController.delete(employee.getEmployeeid()));
    }


    @Test
        public void deleteNotSuccess() {
        Employee employee = new Employee();
        employee.setEmployeeid(1);
        employee.setName("Yaman");
        when(employeeService.delete(employee.getEmployeeid())).thenReturn("ID NOT FOUND");
        Assert.assertEquals(new ResponseEntity<String>("ID NOT FOUND", HttpStatus.BAD_REQUEST), employeeController.delete(employee.getEmployeeid()));
    }

}