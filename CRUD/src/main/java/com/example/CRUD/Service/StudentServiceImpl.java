package com.example.CRUD.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.CRUD.DTO.StudentDto;
import com.example.CRUD.Entity.Student;
import com.example.CRUD.Repository.IStudentRepo;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentRepo studentRepository;

//	@Autowired
//	private StudentConveter studentConveter;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Optional<StudentDto> save(StudentDto studentDto) {
	
			Student student=modelMapper.map(studentDto, Student.class);
			studentRepository.save(student);
			return Optional.of(modelMapper.map(student, StudentDto.class));

	}

	@Override
	public Optional<StudentDto> findById(Long id) {

		Student student = studentRepository.findById(id).orElse(null);
		// Optional<StudentDto>
		// studentDto=studentConveter.entityToDto(studentRepository.findById(id));
		// return student.map((s)->this.studentConveter.entityToDto(s));
		// return student.map(this::convertToDTO);

			return Optional.of(modelMapper.map(student, StudentDto.class));
	}

	@Override
	public List<StudentDto> findAll() {

		List<Student> listStudent = studentRepository.findAll();
		List<StudentDto> listStudentDto =
				listStudent.stream().map(student -> modelMapper.map(student, StudentDto.class))
						   .collect(Collectors.toList());

		return listStudentDto;
	}

	@Override
	public List<StudentDto> findByName(String name) {
		List<Student> listStudent = studentRepository.findByName(name);
		
		return listStudent.stream().map(student -> modelMapper.map(student, StudentDto.class))
						  .collect(Collectors.toList());//stream to collection converter
	}

	@Override
	public void delete(Long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public StudentDto updateStudent(Long id, StudentDto studentDto) {
		Student student=studentRepository.findById(id).orElse(null);
		//modelMapper.map(studentDto,StudentDto.class);
		student.setName(studentDto.getName());
		student.setAge(studentDto.getAge());
		student.setEmail(studentDto.getEmail());
		student.setAttendance(studentDto.isAttendance());
		
		studentRepository.save(student);

		
		return modelMapper.map(student, StudentDto.class);
	}

}
