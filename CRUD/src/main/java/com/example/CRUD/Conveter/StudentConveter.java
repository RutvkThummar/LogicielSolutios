package com.example.CRUD.Conveter;

import org.springframework.stereotype.Component;

import com.example.CRUD.DTO.StudentDto;
import com.example.CRUD.Entity.Student;

@Component
public class StudentConveter {

	public StudentDto entityToDto(Student student) {

		System.out.println("inSide studentDto convertToDto : " + student);
		
		StudentDto studentDto=new StudentDto();
		studentDto.setId(student.getId());
		studentDto.setName(student.getName());
		studentDto.setEmail(student.getEmail());
		studentDto.setAttendance(student.isAttendance());
		studentDto.setAge(student.getAge());

		return studentDto;
	}
	
	public Student dtoToEntity(StudentDto studentDto) {

		System.out.println("inSide studentDto convertToDto : " + studentDto);
		Student student = new Student();
		student.setId(studentDto.getId());
		student.setName(studentDto.getName());
		student.setEmail(studentDto.getEmail());
		student.setAttendance(studentDto.isAttendance());
		student.setAge(studentDto.getAge());

		return student;
	}


}
