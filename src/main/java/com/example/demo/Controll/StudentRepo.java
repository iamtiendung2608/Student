package com.example.demo.Controll;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.StudentInfo.Student;
public interface StudentRepo  extends JpaRepository<Student,Integer>{
	
}