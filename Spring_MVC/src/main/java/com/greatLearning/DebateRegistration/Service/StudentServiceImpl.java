package com.greatLearning.DebateRegistration.Service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatLearning.DebateRegistration.entity.Student;


@Repository
public class StudentServiceImpl implements StudentsService {
	@SuppressWarnings("unused")
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
	public List<Student> findAll() {
		Transaction tx = session.beginTransaction();

		// find all the records from db

		@SuppressWarnings("unchecked")
		List<Student> students = session.createQuery("from Student").list();
		tx.commit();

		return students;
	}

	@Override
	@Transactional
	public Student findById(int theId) {
		Student student = new Student();

		Transaction tx = session.beginTransaction();

		// find record with id from db table
		student = session.get(Student.class, theId);
		tx.commit();

		return student;
	}

	@Override
	@Transactional
	public void save(Student theStudent) {
		Transaction tx = session.beginTransaction();
		session.save(theStudent);
		tx.commit();

	}

	@Override
	@Transactional
	public void deleteById(int theId) {

		Transaction tx = session.beginTransaction();
		Student student = session.get(Student.class, theId);
		session.delete(student);
		tx.commit();

	}

}
