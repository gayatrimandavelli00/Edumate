package com.ts.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity

public class EBooks {
	@Id@GeneratedValue
	private int bid;
	private String bname;
	private String dep;
	private String pdf;
	private String img;
	private String bdec;
	private String aname;
	public EBooks() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EBooks(int bid, String bname, String dep, String pdf, String img, String bdec, String aname) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.dep = dep;
		this.pdf = pdf;
		this.img = img;
		this.bdec = bdec;
		this.aname = aname;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getBdec() {
		return bdec;
	}

	public void setBdec(String bdec) {
		this.bdec = bdec;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	@Override
	public String toString() {
		return "Ebook [bid=" + bid + ", bname=" + bname + ", dep=" + dep + ", pdf=" + pdf + ", img=" + img + ", bdec="
				+ bdec + ", aname=" + aname + "]";
	}

	
}