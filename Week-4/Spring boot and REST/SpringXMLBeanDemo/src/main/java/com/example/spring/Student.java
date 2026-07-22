package com.example.spring;

public class Student {
    private int id;
    private String name;
    private Address address;

    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void setAddress(Address address){
        this.address = address;
    }

    public void display(){
        System.out.println("Student Id : " + id);
        System.out.println("Student Name : " + name);
        address.displayAddress();
    }
}