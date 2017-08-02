package com.vikas.receiver;

import org.springframework.stereotype.Component;

import com.vikas.model.Student;

@Component
public class StudentReceiver {
	
	public void receiveMessage(Student student){
		
		System.out.println("The method has been traversed");
		System.out.println("The Message received is:"+student);
		
	}
}
