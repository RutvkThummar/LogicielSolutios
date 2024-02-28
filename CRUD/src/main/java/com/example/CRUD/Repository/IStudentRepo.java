package com.example.CRUD.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CRUD.Entity.Student;


@Repository
public interface IStudentRepo extends JpaRepository<Student,Long> {
	
	 List<Student> findByName(String name);
	
	
}
