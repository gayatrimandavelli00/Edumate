package com.ts.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ts.dto.Organizer;
import com.ts.dto.Student;
import com.ts.dto.TimeTable;


public class HibernateTemplate {

	private static SessionFactory sessionFactory;
	
	static {
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}
	
	public static int addObject(Object obj)
	{
		System.out.println("Inside Template...");
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.save(obj);
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static Object getObject(Class c,Serializable serializable)
	{
		Object obj=null;
		
		try {			
			return sessionFactory.openSession().get(c,serializable);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public static Object getObjectByUserPass(String loginId,String password) {
	
	String queryString = "from Student where emailId = :loginId and password =:password";
	  Query query = sessionFactory.openSession().createQuery(queryString);
	  query.setString("loginId", loginId);
	  query.setString("password", password);
	  Object queryResult = query.uniqueResult();
	  Student student = (Student)queryResult;
	  return student; 
	}
	
	public static Object getObjectByUserPass1(String loginId,String password) {
		
		String queryString = "from Organizer where organizerEmail = :loginId and organizerPassword =:password";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("loginId", loginId);
		  query.setString("password", password);
		  Object queryResult = query.uniqueResult();
		  Organizer organizer = (Organizer)queryResult;
		  return organizer; 
		}
	public static Object getObjectByEmail(String email) {
		
		String queryString = "from Student where emailId = :email";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("email", email);
		  Object queryResult = query.uniqueResult();
		  Student student = (Student)queryResult;
		  return student; 
		}
public static Object getObjectByEmail1(String email) {
		
		String queryString = "from Organizer where emailId = :email";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("email", email);
		  Object queryResult = query.uniqueResult();
		  Student student = (Student)queryResult;
		  return student; 
		}
	
	public static List<Object> getObjectListByQuery(String query)
	{
		return sessionFactory.openSession().createQuery(query).list();
	}
	
	public static int updateObject(Object obj)
	{
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.saveOrUpdate(obj);
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static int deleteObject(Class c,Serializable serializable)
	{
		int result=0;
		
		Session session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
			Object obj=session.get(c,serializable);
			
			session.delete(obj);
			
			tx.commit();
			
			result=1;
						
		} catch (Exception e) {
			
			e.printStackTrace();
			
			tx.rollback();
		}
		
		return result;
	}

	public static List<Object> getObjectListByName(Class c, String columName, String value) {
		Session session=sessionFactory.openSession();
		  Criteria criteria = session.createCriteria(c);
			Criterion nameCriterion = Restrictions.eq(columName, value);
			criteria.add(nameCriterion);
			return criteria.list();
	}
	
	public static long getCount() {
		String queryString = "select count(*) from Student";
		Query query = sessionFactory.openSession().createQuery(queryString);
		long x = (long)query.uniqueResult();
		return x;
		}
		public static long getCount1() {
		String queryString = "select count(*) from EBooks";
		Query query = sessionFactory.openSession().createQuery(queryString);
		long x = (long)query.uniqueResult();
		return x;
		}
		public static long getCount2() {
		String queryString = "select count(*) from InterviewQuestions";
		Query query = sessionFactory.openSession().createQuery(queryString);
		long x = (long)query.uniqueResult();
		return x;
		}
		public static long getCount3() {
		String queryString = "select count(*) from ItemDetails";
		Query query = sessionFactory.openSession().createQuery(queryString);
		long x = (long)query.uniqueResult();
		return x;
		}
	
	/*public static Object getObjectByUserEvent(int tid) {
		System.out.println(tid);
		  Query query = sessionFactory.openSession().createQuery("from TimeTable where tid="+tid);
		  System.out.println(query);
		  query.setInteger("tid", tid);
		  //query.setString("event", event);
		  Object queryResult = query.uniqueResult();
		  TimeTable time = (TimeTable)queryResult;
		  return time; 
		}*/
	

}
