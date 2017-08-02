package com.vikas.controller;

import java.io.IOException;


import java.util.List;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import com.vikas.model.Student;
import com.vikas.repository.StudentRepository;


@Service
public class StudentService {

	@Value("${exchange.name}")
	private String exchange;
	
	
	@Value("${message.key}")
	private String messageKey;
	
	@Value("${message.queue}")
	private String messageQueue;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private StudentRepository studentRepository;

	public List<Student> insert(List<Student> student) {

		List<Student> students_new = studentRepository.save(student);

		return students_new;
	}

	public Student findStudent(int id) {

		Student student_new = studentRepository.findOne(id);

		return student_new;
	}

	public Student saveStudent(Student student) {

		Student savedStudent = studentRepository.save(student);
		rabbitTemplate.convertAndSend(exchange, messageKey,savedStudent);
		return savedStudent;
	}
}
