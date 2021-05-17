package com.ts.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity

public class InterviewQuestions {
	
	@Id@GeneratedValue
	private int iqId;
	private String companyName;
	private String questionName;
	private String description;
	private String testCases;
	private String explanation;
	
	public InterviewQuestions() {
		super();
	}
	
	public InterviewQuestions(int iqId, String companyName, String questionName, String description, String testCases,
			String explanation) {
		super();
		this.iqId = iqId;
		this.companyName = companyName;
		this.questionName = questionName;
		this.description = description;
		this.testCases = testCases;
		this.explanation = explanation;
	}
	
	public int getIqId() {
		return iqId;
	}
	public void setIqId(int iqId) {
		this.iqId = iqId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getQuestionName() {
		return questionName;
	}
	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTestCases() {
		return testCases;
	}
	public void setTestCases(String testCases) {
		this.testCases = testCases;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	@Override
	public String toString() {
		return "InterviewQuestions [iqId=" + iqId + ", companyName=" + companyName + ", questionName=" + questionName
				+ ", description=" + description + ", testCases=" + testCases + ", explanation=" + explanation + "]";
	}
	
	

}
