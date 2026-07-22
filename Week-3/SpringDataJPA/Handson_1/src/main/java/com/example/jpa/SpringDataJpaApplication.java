package com.example.jpa;
import org.springframework.boot.*;import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.jpa.service.StudentService;
@SpringBootApplication public class SpringDataJpaApplication implements CommandLineRunner{
private final StudentService s; public SpringDataJpaApplication(StudentService s){this.s=s;}
public static void main(String[] a){SpringApplication.run(SpringDataJpaApplication.class,a);}
public void run(String...args){s.saveStudent();s.getStudent();}}