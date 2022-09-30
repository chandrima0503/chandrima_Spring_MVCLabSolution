package com.greatlearning.studentManagement.service;

import java.util.List;

import com.greatlearning.studentManagement.entity.Student;

public interface StudentService {

	public List<Student> getStudents();

	public void saveStudent(Student student);

	public Student getStudentById(int id);

	public void deleteStudentById(int id);

}
