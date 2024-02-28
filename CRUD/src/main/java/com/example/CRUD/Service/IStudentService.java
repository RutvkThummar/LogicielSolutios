package com.example.CRUD.Service;

import java.util.List;
import java.util.Optional;

import com.example.CRUD.DTO.StudentDto;
import com.example.CRUD.Entity.Student;

public interface IStudentService {

	Optional<StudentDto> save(StudentDto StudentDto);

	Optional<StudentDto> findById(Long id);

	void delete(Long id);

	List<StudentDto> findAll();

	List<StudentDto> findByName(String name);

	StudentDto updateStudent(Long id, StudentDto studentDto);

}
