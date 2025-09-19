package com.example.Emp_Mysql.service;

import com.example.Emp_Mysql.entity.Employee;

import java.util.List;


public interface EmployeeService {
    public Employee createEmp(Employee emp);
    public Employee getEmp(Integer empId);
    public Employee updateEmp(Integer empId,Employee emp);

    void deleteEmp(Integer empId);
    public Integer getSalary(Integer empId);
    public Integer getpfAmount(Integer empId);


    List<Employee> getAllEmployees();
}