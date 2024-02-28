package com.example.CRUD;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.CRUD.DTO.StudentDto;
import com.example.CRUD.Service.IStudentService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class JunitApplicationTests {

	@Autowired
	private IStudentService studentService;

	@Test
	@Order(1)
	public void saveStudentTest() {
		StudentDto studentDto = new StudentDto("rutvik", "rutvik@gmail.com", 24, true);

		StudentDto savedStudentTest = studentService.save(studentDto).orElseGet(null);

		assertNotNull(savedStudentTest);
		assertThat(savedStudentTest.getId()).isGreaterThan(0);
		assertEquals(studentDto.getName(), savedStudentTest.getName());

	}

	@Test
	@Order(2)
	public void findByIdTest() {

		Optional<StudentDto> student = studentService.findById(1L);

		// System.out.println(student);
		assertTrue(student.isPresent(), "Entity not found");
		assertThat(student.get().getId()).isEqualTo(1L);

	}

	@Test
	@Order(3)
	public void findAllTest() {

		StudentDto studentDto1 = new StudentDto("yash", "yash@gmail.com", 20, true);
		StudentDto studentDto2 = new StudentDto("yagnik", "yagnik@gmail.com", 22, true);

		// List<StudentDto> listStudent=Arrays.asList(studentDto1,studentDto2);
		studentService.save(studentDto1);
		studentService.save(studentDto2);

		// When
		List<StudentDto> foundStudents = studentService.findAll();

		// Then
		assertEquals(3, foundStudents.size());
		// assertTrue(foundStudents.contains(studentDto1));
		// (foundStudents.contains(studentDto2));

	}

	@Test
	@Order(4)
	public void findByNameTest() {

		List<StudentDto> listStudent = studentService.findByName("rutvik");
		// System.out.println(listStudent);
		for (StudentDto s : listStudent) {
			assertEquals(s.getName(), "rutvik");
		}
	}

	@Test
	@Order(5)
	public void deleteByIdTest() {

		StudentDto student = studentService.findById(2L).orElse(null);

		System.out.println(student.getId());
		studentService.delete(student.getId());
		StudentDto deletedStudent;
		try {
			deletedStudent = studentService.findById(2L).orElseGet(() -> null/* orElse(null */);

		} catch (Exception e) {
			deletedStudent = null;
		}
//		StudentDto deletedStudent = studentService.findById(2L).orElseGet(() -> null/*orElse(null*/);
//		System.out.println(deletedStudent);
// assertThat(studentService.findById(2L)).isEmpty();

		assertThat(deletedStudent).isNull();

	}
	
	@Test
	@Order(6)
	public void updateStudentTest() {
		
		studentService.updateStudent(3L, new StudentDto("ruvi","ruvi@gmail.com",24,true));
		
		StudentDto studentDto=studentService.findById(3L).orElse(null);
		assertEquals(studentDto.getId(),3L);
		assertEquals(studentDto.getEmail(),"ruvi@gmail.com");
		assertEquals(studentDto.getName(),"ruvi");
		assertEquals(studentDto.getAge(),24);
	
	}
	

}
