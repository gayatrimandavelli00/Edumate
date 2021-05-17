package com.dao;

import java.util.List;

import com.ts.db.HibernateTemplate;
import com.ts.dto.Answer;


public class AnswerDAO {

	public int replypost(Answer answer) {
		System.out.println(answer); 
		return HibernateTemplate.addObject(answer);
	}
	public List<Answer> getAllReplies(int x) {
		System.out.println(x);
		List<Answer> reply=(List)HibernateTemplate.getObjectListByQuery("From Answer where quesId="+x);
		return reply;	
	}
}
