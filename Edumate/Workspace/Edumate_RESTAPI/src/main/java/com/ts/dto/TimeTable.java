package com.ts.dto;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity

public class TimeTable {
	
	@Id
	@GeneratedValue
	private int tid;
	private String event;
	private String date;
	private String time;
	private int regNo;
	
	public int getRegNo() {
		return regNo;
	}

	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}
	
	public int getTid() {
		return tid;
	}
	
	public TimeTable() {}
	
	public TimeTable(String event, String date, String time) {
		super();
		this.event = event;
		this.date = date;
		this.time = time;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "TimeTable [event=" + event + ", date=" + date + ", time=" + time + ", regNo=" + regNo + "]";
	}

	
	
}
