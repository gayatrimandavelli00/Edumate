package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ts.db.HibernateTemplate;
import com.ts.dto.Student;
import com.ts.dto.TimeTable;

public class StudentDAO {
	private SessionFactory factory = null;

	public Student getStuByUserPass(String emailId,String password) {

		return (Student)HibernateTemplate.getObjectByUserPass(emailId,password);
	}
	public Student getObjectByEmail(String emailId) {
		return (Student)HibernateTemplate.getObjectByEmail(emailId);
	}

	public int register(Student student) {
		System.out.println(student); 
		return HibernateTemplate.addObject(student);
	}
	public List<Student> getAllStudents() {
		List<Student> students=(List)HibernateTemplate.getObjectListByQuery("From Student");
		System.out.println("Inside All Employees ..."+students);
		return students;
	}
	public void editProfile(Student student) {
		//Update
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml");
			SessionFactory factory = config.buildSessionFactory();
			Session session = factory.openSession();
			
			session.saveOrUpdate(student);
			
			Transaction txn = session.beginTransaction();
			txn.commit();			
			session.close();
		}
	
	public List<Student> getStudent(int regdNo) {
		List<Student> students=(List)HibernateTemplate.getObjectListByQuery("From Student where regdNo="+regdNo);
		System.out.println("Inside All Employees ..."+students);
		return students;
	}
	
	public long getCount() {
		return HibernateTemplate.getCount();
		}

}