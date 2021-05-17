package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.ts.db.HibernateTemplate;
import com.ts.dto.QPost;

public class QPostDAO {
	private SessionFactory factory = null;

	public static int postq(QPost qpostDAO) {
			System.out.println(qpostDAO); 
			return HibernateTemplate.addObject(qpostDAO);
		}
	
	public List<QPost> getAllQs() {
		List<QPost> q=(List)HibernateTemplate.getObjectListByQuery("From QPost");
		System.out.println("Inside All Employees ..."+q);
		return q;
	}
			
	}


