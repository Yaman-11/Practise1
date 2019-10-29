package com.example.practise.Practise.controller;

import com.example.practise.Practise.entity.Employee;
import com.example.practise.Practise.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET, value = "/show")
    public List<Employee> show() {
        return employeeService.show();

    }

    @RequestMapping(method = RequestMethod.POST, value = "add")
    public ResponseEntity<String> add(@RequestBody Employee employee)
    {
        String response=employeeService.add(employee);
        if(response=="NOT SUCCESSFULL")
        {
            return(new ResponseEntity<String>("MORE THAN 5 CAHARCTERS", HttpStatus.BAD_REQUEST));
        }
        return (new ResponseEntity<String>("ADDED SUCCESSFULLY",HttpStatus.OK));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/find/{id}")
    public Employee find(@PathVariable int id)
    {
        return employeeService.find(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/name/{id}")
    public ResponseEntity<String> name(@PathVariable int id)
    {
        String response=employeeService.name(id);
        if(response.equals("ID NOT FOUND"))
        {
            return (new ResponseEntity<String>("ID NOT FOUND",HttpStatus.BAD_REQUEST));
        }
       return(new ResponseEntity<String>(response,HttpStatus.OK));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id)
    {
        String response=employeeService.delete(id);
        if(response.equals("ID NOT FOUND"))
        {
            return (new ResponseEntity<String>("ID NOT FOUND", HttpStatus.BAD_REQUEST));
        }
        return (new ResponseEntity<String>(response,HttpStatus.OK));
    }


}
