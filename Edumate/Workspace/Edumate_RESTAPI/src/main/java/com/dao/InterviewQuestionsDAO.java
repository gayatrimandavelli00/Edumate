package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.ts.db.HibernateTemplate;
import com.ts.dto.InterviewQuestions;

public class InterviewQuestionsDAO {
	
	private SessionFactory factory = null;
	
	public int register(InterviewQuestions iq) {
		System.out.println(iq); 
		return HibernateTemplate.addObject(iq);
	}
	public List<InterviewQuestions> getAllQuestions() {
		List<InterviewQuestions> interviewQuestions=(List)HibernateTemplate.getObjectListByQuery("From InterviewQuestions");
		//System.out.println("Inside All Employees ..."+timeTable);
		return interviewQuestions;
	}
	
	public long getCount() {
		// TODO Auto-generated method stub
		return HibernateTemplate.getCount2();
		}
}
