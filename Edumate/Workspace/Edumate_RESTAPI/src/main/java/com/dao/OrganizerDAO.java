package com.dao;

import java.util.List;


import org.hibernate.SessionFactory;


import com.ts.db.HibernateTemplate;
import com.ts.dto.Organizer;

public class OrganizerDAO {
	private SessionFactory factory = null;

	public Organizer getOrgByUserPass(String emailId,String password) {

		return (Organizer)HibernateTemplate.getObjectByUserPass1(emailId,password);
	}
	public Organizer getObjectByEmail(String emailId) {
		return (Organizer)HibernateTemplate.getObjectByEmail1(emailId);
	}

	public int register(Organizer organizer) {
		System.out.println(organizer); 
		return HibernateTemplate.addObject(organizer);
	}
	public List<Organizer> getAllOrganizers() {
		List<Organizer> organizers =(List)HibernateTemplate.getObjectListByQuery("From Organizer");
		System.out.println("Inside All Employees ..."+organizers);
		return organizers;
	}
	
	

}
