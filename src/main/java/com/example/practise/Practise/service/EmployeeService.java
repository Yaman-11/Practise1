package com.example.practise.Practise.service;

import com.example.practise.Practise.entity.Employee;
import com.example.practise.Practise.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> show() {
        List<Employee> al = new ArrayList<>();
        for (Employee e : employeeRepository.findAll()) {
            al.add(e);

        }
        return al;
    }


    public String add(Employee employee) {
        if (employee.getName().length() >= 5) {
            return "NOT SUCCESSFULL";
        }
        employeeRepository.save(employee);
        return "Added Successfully";
    }

    public Employee find(int id) {
        return employeeRepository.findById(id).get();
    }


    public String name(int id) {
        for (Employee e : employeeRepository.findAll()) {
            if (e.getEmployeeid() == id) {
                return e.getName();
            }

        }
        return "ID NOT FOUND";
    }

    public String delete(int id) {
        for (Employee e : employeeRepository.findAll()) {
            if (e.getEmployeeid() == id) {
                employeeRepository.deleteById(id);
                return "DELETED SUCCESSFULLY";
            }
        }
        return "ID NOT FOUND";

    }
}