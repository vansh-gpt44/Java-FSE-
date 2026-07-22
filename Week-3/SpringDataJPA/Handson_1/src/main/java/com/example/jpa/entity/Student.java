package com.example.jpa.entity;
import jakarta.persistence.*;
@Entity @Table(name="students")
public class Student{
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
private String name; private String course; private int age;
public Student(){} public Student(String n,String c,int a){name=n;course=c;age=a;}
public Long getId(){return id;} public String getName(){return name;} public String getCourse(){return course;} public int getAge(){return age;}
public void setName(String n){name=n;}
}