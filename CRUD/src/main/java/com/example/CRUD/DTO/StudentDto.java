package com.example.CRUD.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDto {

	private Long id;
	private String name;
	private String email;
	//private String password;
	private int age;
	private boolean attendance;
	
	public StudentDto(String name, String email, int age, boolean attendance) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.attendance = attendance;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAttendance(boolean attendance) {
		this.attendance = attendance;
	}
	
	
	

}
