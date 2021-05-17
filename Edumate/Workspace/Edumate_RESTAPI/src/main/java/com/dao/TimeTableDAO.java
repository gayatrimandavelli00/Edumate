package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ts.db.HibernateTemplate;
import com.ts.dto.Student;
import com.ts.dto.TimeTable;

public class TimeTableDAO {

	public int addTasks(TimeTable timetable) {
		System.out.println(timetable); 
		return HibernateTemplate.addObject(timetable);
	}

	public List<TimeTable> getAllTasks(int stuNo) {
		List<TimeTable> timeTable=(List)HibernateTemplate.getObjectListByQuery("From TimeTable where regNo="+stuNo);
		System.out.println("Inside All Employees ..."+timeTable);
		return timeTable;
	}

	public void editTask(TimeTable timetable) {
		//Update
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml");
			SessionFactory factory = config.buildSessionFactory();
			Session session = factory.openSession();
			
			session.saveOrUpdate(timetable);
			
			Transaction txn = session.beginTransaction();
			txn.commit();			
			session.close();
		}
	
	/*public TimeTable getOneTask(int tid) {

		return (TimeTable)HibernateTemplate.getObjectByUserEvent(tid);
	}*/
	
public TimeTable getOneTask(int tid) {
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		
		TimeTable employee = (TimeTable) session.get(TimeTable.class, tid);
		session.close();
		
		System.out.println(employee);
		return employee;		
	}
	
	//Delete
		public void deleteTask(TimeTable timetable) {
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml");
			SessionFactory factory = config.buildSessionFactory();
			Session session = factory.openSession();
			
			session.delete(timetable);
			
			Transaction txn = session.beginTransaction();
			txn.commit();			
			session.close();
		}
}
