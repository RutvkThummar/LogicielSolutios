package com.example.CRUD.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	//private String password;
	private int age;
	private boolean attendance;
	
	
	public Student(String name, String email, int age, boolean attendance) {
		super();
		//this.id = id;
		this.name = name;
		this.email = email;
		//this.password = password;
		this.age = age;
		this.attendance = attendance;
	}
	
	
	
}
