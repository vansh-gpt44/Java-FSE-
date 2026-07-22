package com.example.jpa.service;
import org.springframework.stereotype.Service;
import com.example.jpa.entity.Student;import com.example.jpa.repository.StudentRepository;
@Service public class StudentService{
private final StudentRepository repo; public StudentService(StudentRepository r){repo=r;}
public void saveStudent(){repo.save(new Student("Rahul","Java",22));}
public void getStudent(){System.out.println(repo.findByName("Rahul").getName());}}