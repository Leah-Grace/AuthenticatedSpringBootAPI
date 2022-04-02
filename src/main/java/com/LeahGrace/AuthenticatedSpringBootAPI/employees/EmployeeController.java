package com.LeahGrace.AuthenticatedSpringBootAPI.employees;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

//    private final EmployeeRepository repository;
//
//    public EmployeeController(EmployeeRepository repository){
//        this.repository = repository;
//    }

    private Map<Long, Employee> employees = new HashMap<>();

    //Create - create one employee
    //Read - get one employee by id/ get all employees
    //Update - update one employee by id
    //Delete - delete by employee id.

    @GetMapping
    public List<Employee> all(){
        return (List<Employee>) employees.values();

    }
}
