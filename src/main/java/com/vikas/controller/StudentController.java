package com.vikas.controller;

import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vikas.model.Student;



@RestController
public class StudentController {

	
	
	@Autowired
	private StudentService studentService;
	
	

	@RequestMapping(value = "/save/students", method = RequestMethod.POST)
	public List<Student> insertStudents(@RequestBody List<Student> student) throws JsonProcessingException {
		
		
		List<Student> s = studentService.insert(student);
		System.out.println("The Message in Controller is:"+s);
		return s;
	}
	
	@RequestMapping(value="/student/{id}" , method = RequestMethod.GET)
	public Student findStudent(@PathVariable int id){
		
		Student s = studentService.findStudent(id);
		return s;
}
	
	@RequestMapping(value="/save/oneStudent" , method=RequestMethod.POST )
	public  Student oneStudent(@RequestBody Student student) throws IOException{
		
		Student savedStudent = studentService.saveStudent (student);
		System.out.println(savedStudent);
		return savedStudent;
	}
}
