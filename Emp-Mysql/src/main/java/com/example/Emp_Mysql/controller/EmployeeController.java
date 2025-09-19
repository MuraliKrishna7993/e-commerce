package com.example.Emp_Mysql.controller;

import com.example.Emp_Mysql.entity.Employee;
import com.example.Emp_Mysql.serviceImpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl empService;

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello world";
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp){
        return new ResponseEntity<Employee>(empService.createEmp(emp),HttpStatus.CREATED);
    }

    @GetMapping("/{empId}")
    public ResponseEntity<Employee> getEmployeebyId(@PathVariable("empId") Integer empId){
        return new ResponseEntity<Employee>(empService.getEmp(empId),HttpStatus.FOUND);
    }
    @PutMapping("/{empId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("empId") Integer empId,@RequestBody Employee emp){
        return new ResponseEntity<Employee>(empService.updateEmp(empId, emp),HttpStatus.OK);
    }
    @DeleteMapping("/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("empId") Integer empId){
        empService.deleteEmp(empId);
        return new ResponseEntity<String>("Employee deleted", HttpStatus.OK);
    }

    @GetMapping("/salary/{empId}")
    public ResponseEntity<Integer> getSalary(@PathVariable("empId") Integer empId){
        return new ResponseEntity<Integer>(empService.getSalary(empId),HttpStatus.OK);
    }

    @GetMapping("/pfAmount/{empId}")
    public ResponseEntity<Integer> getpf(@PathVariable("empId") Integer empId){
        return new ResponseEntity<Integer>(empService.getpfAmount(empId),HttpStatus.OK);
    }
    @GetMapping("/allEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<List<Employee>>(empService.getAllEmployees(),HttpStatus.FOUND);
    }

}