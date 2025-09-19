package com.example.Emp_Mysql.entity;

import jakarta.persistence.*;


@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue
    private int employeeId;

    private String firstName;

    private String lastName;

    private String email;

    private int salary;

    private int experience;

    private int pfAmount;

    public int getExperience() {
        return experience;
    }


    public void setExperience(int experience) {
        this.experience = experience;
    }





    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }


    public Employee(int employeeId, String firstName, String lastName, String email, int salary, int experience,
                    int pfAmount) {
        super();
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.salary = salary;
        this.experience = experience;
        this.pfAmount = pfAmount;
    }



    public int getEmployeeId() {
        return employeeId;
    }


    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public int getSalary() {
        return salary;
    }


    public void setSalary(int salary) {
        this.salary = salary;
    }


    public int getPfAmount() {
        return pfAmount;
    }


    public void setPfAmount(int pfAmount) {
        this.pfAmount = pfAmount;
    }

}