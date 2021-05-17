package com.ts.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Organizer {
	
	@Id
	@GeneratedValue
	private int organizerId;
	private String organizerName;
	private String organizerEmail;
	private String organizerPassword;
	
	public  Organizer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Organizer(int organizerId, String organizerName, String organizerEmail, String organizerPassword) {
		super();
		this.organizerId = organizerId;
		this.organizerName = organizerName;
		this.organizerEmail = organizerEmail;
		this.organizerPassword = organizerPassword;
	}
	public int getOrganizerId() {
		return organizerId;
	}
	public void setOrganizerId(int organizerId) {
		this.organizerId = organizerId;
	}
	public String getOrganizerName() {
		return organizerName;
	}
	public void setOrganizerName(String organizerName) {
		this.organizerName = organizerName;
	}
	public String getOrganizerEmail() {
		return organizerEmail;
	}
	public void setOrganizerEmail(String organizerEmail) {
		this.organizerEmail = organizerEmail;
	}
	public String getOrganizerPassword() {
		return organizerPassword;
	}
	public void setOrganizerPassword(String organizerPassword) {
		this.organizerPassword = organizerPassword;
	}
	@Override
	public String toString() {
		return "Organizer [organizerId=" + organizerId + ", organizerName=" + organizerName + ", organizerEmail="
				+ organizerEmail + ", organizerPassword=" + organizerPassword + "]";
	}
}
