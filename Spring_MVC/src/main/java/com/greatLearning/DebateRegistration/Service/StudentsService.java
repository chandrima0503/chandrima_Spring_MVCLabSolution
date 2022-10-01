package com.greatLearning.DebateRegistration.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatLearning.DebateRegistration.entity.Student;
@Service
public interface StudentsService {
	
	public List<Student>findAll();

	 public void save(Student theStudent);
	 public void deleteById(int theId);

	public Student findById(int theId);

}
