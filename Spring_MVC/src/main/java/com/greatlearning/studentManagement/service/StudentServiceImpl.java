package com.greatlearning.studentManagement.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.studentManagement.entity.Student;

@Service
@Component
public class StudentServiceImpl implements StudentService {
	private SessionFactory sessionFactory;

	// create session
	private Session session;

	@Autowired
	public StudentServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}

	@Override
	@Transactional
	public List<Student> getStudents() {
		Transaction tx = session.beginTransaction();
		List<Student> students = session.createQuery("from Student").list();
		tx.commit();
		return students;
	}

	@Override
	@Transactional
	public Student getStudentById(int id) {
		Student student = new Student();
		Transaction tx = session.beginTransaction();
		// find record with id from db table
		student = session.get(Student.class, id);
		tx.commit();
		return student;
	}

	@Override
	@Transactional
	public void saveStudent(Student student) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(student);
		tx.commit();
	}

	@Override
	@Transactional
	public void deleteStudentById(int id) {
		Transaction tx = session.beginTransaction();
		Student student = session.get(Student.class, id);
		session.delete(student);
		tx.commit();
	}
}
