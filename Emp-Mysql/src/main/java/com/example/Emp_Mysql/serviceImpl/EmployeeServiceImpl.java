package com.example.Emp_Mysql.serviceImpl;

import java.util.List;
import java.util.Objects;

import com.example.Emp_Mysql.entity.Employee;
import com.example.Emp_Mysql.repository.EmployeeRepository;
import com.example.Emp_Mysql.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository empRepo;


    @Override
    public void deleteEmp(Integer empId) {
        empRepo.deleteById(empId);
    }

    public Employee getEmp(Integer empId) {
        // TODO Auto-generated method stub
        return empRepo.findById(empId).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public Employee createEmp(Employee emp) {
        int salary = emp.getSalary();
        int exp= emp.getExperience();
        int pf= 0;
        if(exp >=5) {
            pf=(int) (salary*0.10);
        }
        else if(exp >5 && exp <=10){
            pf=(int) (salary*0.12);
        }
        else if(exp >10 && exp <=15){
            pf=(int) (salary*0.15);
        }
        else {
            pf=0;
        }
        emp.setPfAmount(pf);
        return empRepo.save(emp);
    }

    @Override
    public Employee updateEmp(Integer empId, Employee emp) {
        // TODO Auto-generated method stub
        Employee existing = empRepo.findById(empId).orElseThrow();
        Object  salary = emp.getSalary();
        if(Objects.nonNull(emp.getFirstName())) {
            existing.setFirstName(emp.getFirstName());
        }
        if(Objects.nonNull(emp.getLastName())) {
            existing.setLastName(emp.getLastName());
        }
        if(Objects.nonNull(emp.getEmail())) {
            existing.setEmail(emp.getEmail());
        }
        if(salary != null){
            existing.setSalary((int) salary);
        }

        if(Objects.nonNull(emp.getPfAmount())){
            throw new RuntimeException();
        }
        empRepo.save(existing);
        return existing;
    }

    public Integer getSalary(Integer empId) {
        // TODO Auto-generated method stub
        Employee existing= empRepo.findById(empId).orElseThrow();
        return existing.getSalary();
    }
    public Integer getpfAmount(Integer empId) {
        // TODO Auto-generated method stub
        Employee existing= empRepo.findById(empId).orElseThrow();
        return existing.getPfAmount();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }


}