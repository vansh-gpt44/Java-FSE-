package com.example.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {

        ApplicationContext context =
            new ClassPathXmlApplicationContext("spring-config.xml");

        Student student1 = (Student) context.getBean("student");
        student1.display();

        System.out.println("----------------");

        Student student2 = (Student) context.getBean("student");
        student2.display();

        System.out.println("Same Student Object ? " + (student1 == student2));

        Address address1 = (Address) context.getBean("address");
        Address address2 = (Address) context.getBean("address");

        System.out.println("Same Address Object ? " + (address1 == address2));
    }
}