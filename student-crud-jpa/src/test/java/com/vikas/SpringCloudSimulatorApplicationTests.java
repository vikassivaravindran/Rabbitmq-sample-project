package com.vikas;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vikas.controller.StudentService;
import com.vikas.model.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCloudSimulatorApplicationTests {

	@Autowired
	private StudentService StudentService;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void studentInsert(){
	
		Student expected_output = new Student(20,"Vignesh",100f);
		Student actual_output = StudentService.saveStudent(expected_output);
		if(expected_output.equals(actual_output)){
			System.out.println("Equal");
		}
		assertEquals(expected_output.getName(), actual_output.getName());
		assertEquals(expected_output, actual_output);
	}
	
	@Test
	public void findStudentById(){
		
		int id = 20;
		Student student = StudentService.findStudent(id);
		assertEquals(student.getId(),id);
		
	}
	
	@Test
	public void insertListofStudents(){
		List<Student> first_List =  Arrays.asList(new Student(20,"Vikas",100.67f),new Student(29,"Vignesh",89.76f));
		List<Student> students_List = Arrays.asList(new Student(20,"Vikas",100.67f),new Student(29,"Vignesh",89.76f));
		List<Student> students_new = StudentService.insert(students_List);
		assertEquals(students_new,first_List);
	}
}
