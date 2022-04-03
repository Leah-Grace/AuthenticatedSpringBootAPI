package com.LeahGrace.AuthenticatedSpringBootAPI.employees;

import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private Map<Long, Employee> employees = new HashMap<>();
    private AtomicLong idCounter = new AtomicLong();

//    private final EmployeeRepository repository;
//
//    public EmployeeController(EmployeeRepository repository){
//        this.repository = repository;
//    }

    public EmployeeController() {
        Long id = idCounter.incrementAndGet();
        employees.put(id, new Employee(id,"Jim", "Semicolon Finder", 25));
        id = idCounter.incrementAndGet();
        employees.put(id, new Employee(id, "Keith", "Comedian", 26));
    }

    //Create - create one employee
    //Read - get one employee by id/ get all employees
    //Update - update one employee by id
    //Delete - delete by employee id.

    @GetMapping
    public List<Employee> all(){
        return new ArrayList<Employee>(employees.values());
    }

    @GetMapping("/{id}")
    public Employee employe(@PathVariable Long id) {
        return employees.get(id);
    }

    @PostMapping
    public Employee newEmployee(@RequestBody Employee newEmployee) {
        Long id = idCounter.incrementAndGet();
        newEmployee.setId(id);
        employees.put(id, newEmployee);
        return newEmployee;
    }

    //Update - update one employee by id - - commonly authenticated
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updateData) {
        Employee emp = employees.get(id);

        if(updateData.getName() != null) {
            emp.setName(updateData.getName());
        }
        if(updateData.getRole() != null) {
            emp.setRole(updateData.getRole());
        }
        if(updateData.getAge() != null){
            emp.setAge(updateData.getAge());
        }


        return emp;

    }


}
