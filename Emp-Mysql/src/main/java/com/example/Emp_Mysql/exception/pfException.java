package com.example.Emp_Mysql.exception;


public class pfException extends RuntimeException{

    int fieldname;

    public int getFieldname() {
        return fieldname;
    }

    public pfException(int fieldname) {
        super(String.format("%s can not be added manually",fieldname));
        this.fieldname = fieldname;
    }

    public pfException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }





}